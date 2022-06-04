package com.zhang.sframe.zioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SfAutowired
 * 标识需要注入依赖。默认依据类型注入。可传入类名，依据类名注入。
 *
 * @author snow
 * @since 2022/06/05
 */
@Target({ElementType.FIELD}) // 只能用在字段上
@Retention(RetentionPolicy.RUNTIME) // 声明生命周期，保留到运行时
public @interface SfAutowired {
}
