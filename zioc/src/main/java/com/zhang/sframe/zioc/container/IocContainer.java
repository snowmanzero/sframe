package com.zhang.sframe.zioc.container;

import com.zhang.sframe.zcommon.verify.util.CollectionUtil;
import com.zhang.sframe.zioc.filter.BeanFilter;
import com.zhang.sframe.zioc.util.BeanUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Ioc容器
 *
 * @author snow
 * @date 2022/05/24
 */
public class IocContainer {
    private Map<String, Object> beanMap;

    private String packName;

    private String[] args;

    public <T> IocContainer(Class<T> clazz, String[] args) {
        this.packName = clazz.getPackage().getName();
        this.args = args;

        // 初始化bean容器
        init();
    }

    public void init() {
        if (CollectionUtil.isNotEmpty(beanMap)) {
            // 容器初始化后 不再初始化
            return;
        }
        beanMap = new HashMap<>();

        // 扫描目标包及以下的所有类
        initBean();
        initAttributes();
    }

    private void initBean() {
        // todo
        List<Class<?>> classes = BeanUtil.getClasses(packName);

        // 过滤出注解标记的类
        filted(classes);

        System.out.println(beanMap);
    }

    private void filted(List<Class<?>> classes) {
        classes.stream().filter(new BeanFilter()).forEach(item -> {
            try {
                beanMap.put(item.getName().toLowerCase(Locale.US), item.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private void initAttributes() {
        // todo
    }

    public <T> T getBean(String name, Class<T> clazz) {
        Object bean = beanMap.get(name);
        return (T) bean;
    }
}
