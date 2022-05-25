package com.zhang.sframe.zioc.context;

import com.zhang.sframe.zioc.container.IocContainer;

/**
 * 应用上下文
 *
 * @author snow
 * @date 2022/05/24
 */
public class SelfApplicationContext {
    private IocContainer container;

    public <T> SelfApplicationContext(Class<T> clazz, String[] args) {
        container = new IocContainer(clazz, args);
//        container.init();
    }

    /**
     * 获取指定bean
     *
     * @param name  bean Name
     * @param clazz bean Clazz
     * @param <T>   范型
     * @return bean
     */
    public <T> T getBean(String name, Class<T> clazz) {
        return container.getBean(name, clazz);
    }

}
