package com.zhang.sframe.zioc.container;

import com.zhang.sframe.zcommon.verify.util.CollectionUtil;
import com.zhang.sframe.zioc.annotation.SfAutowired;
import com.zhang.sframe.zioc.filter.BeanFilter;
import com.zhang.sframe.zioc.scanner.ClassScanner;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Ioc容器。单例。
 *
 * @author snow
 * @since 2022/05/24
 */
public class IocContainer {
    private static IocContainer iocContainer;

    private Map<String, Object> beanMap;

    private String packName;

    private String[] args;

    private IocContainer() {
    }


    /**
     * 静态内部类。实现容器单例。
     *
     * @author snow
     * @since 2022/05/28
     */
    private static class SingletonInstance {
        private static final IocContainer INSTANCE = new IocContainer();
    }

    /**
     * 获取Ioc容器。
     *
     * @return Ioc容器
     */
    public static <T> IocContainer getIocContainer(Class<T> clazz, String[] args) {
        IocContainer instance = SingletonInstance.INSTANCE;
        instance.packName = clazz.getPackage().getName();
        instance.args = args;

        return instance;
    }

    public void init() {
        if (CollectionUtil.isNotEmpty(beanMap)) {
            // 容器初始化后 不再初始化
            System.out.println("The container has already been initialized and is no longer initialized.");
            return;
        }

        beanMap = new HashMap<>();

        // 扫描目标包及以下的所有类
        initBean();
        beanMap.forEach((k, v) -> System.out.println(k + " >>> " + v));

        // 初始化属性，注入依赖
        initAttributes();
    }

    private void initBean() {
        // todo 干啥来着？？？
        List<Class<?>> classes = ClassScanner.getClasses(packName);

        // 过滤出指定注解标记的类
        classes.stream().filter(new BeanFilter()).forEach(this::accept);
    }

    private void accept(Class<?> item) {
        try {
            beanMap.put(item.getName().toLowerCase(Locale.US), item.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initAttributes() {
        // todo 注入依赖
        // 遍历容器所有bean 找出有依赖的bean，递归注入。注意循环依赖。
        if (CollectionUtil.isEmpty(beanMap)) {
            return;
        }

        beanMap.forEach((key, value) -> {
            Class<?> clazz = value.getClass();

            // 定义的字段
            Field[] declaredFields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);//todo 如果暴力访问 不重置 是否会造成范围扩大？？

            // 可以访问所有字段后 遍历字段，查看字段是否被注解注释过
            for (Field field : declaredFields) {
                if (!field.isAnnotationPresent(SfAutowired.class)) {// todo 注入依赖注解 可扩展性
                    // 不是被标识的 跳过
                    continue;
                }

                SfAutowired sfAutowired = field.getAnnotation(SfAutowired.class);

                Class<?> fieldType = field.getType();
                String fieldTypeName = fieldType.getName();
                Object o = beanMap.get(fieldTypeName.toLowerCase(Locale.US));
                if (fieldType.isInterface()) {
                    // 如果是接口类型 需要在容器中找到对应的实现
                } else {
                    // 如果就是类 则直接根据类名获取实现即可
                }

                // 注入
                try {
                    field.set(value, o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public <T> T getBean(String name, Class<T> clazz) {
        Object bean = beanMap.get(name);
        return (T) bean;
    }
}
