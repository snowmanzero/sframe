package com.zhang.sframe.zioc.filter;

import com.zhang.sframe.zioc.annotation.SfBean;

import java.lang.annotation.Annotation;
import java.util.function.Predicate;

/**
 * Bean过滤器。过滤出被SfBean注解标识的Bean。
 *
 * @author snow
 * @since 2022/05/26
 */
public class BeanFilter implements Predicate<Class<?>> {
    @Override
    public boolean test(Class<?> clazz) {
        System.out.println("aaaa::"+ clazz + ">>>>" + clazz.isAnnotationPresent(SfBean.class));
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations.length == 0) {
            // 无注解的类直接过扔掉。
            return false;
        }

        for (Annotation annotation : annotations) {
            // todo 避免死循环，需要排除元注解，不参与递归判断
            // 当前以自定义注解放到第一位规避死循环
            if (annotation.annotationType() == SfBean.class){
                return true;
            } else {
                // 递归判断是否有SfBean
                return test(annotation.annotationType());
            }
        }
        return false;
    }
}
