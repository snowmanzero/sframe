package com.zhang.sframe.zioc.context;

import com.zhang.sframe.zioc.container.IocContainer;

/**
 * 应用上下文
 *
 * @author snow
 * @since 2022/05/24
 */
public class SelfApplicationContext {

    private final String[] args;
    private final Class<?> clazz;

    private IocContainer container;

    public <T> SelfApplicationContext(Class<T> clazz, String[] args) {
        this.clazz = clazz;
        this.args = args;
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

    public void run() {
        // 初始化
        container = IocContainer.getIocContainer(clazz, args);
        container.init();
    }

}
