package com.zhang.sframe.zioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SfTestField
 *
 * @author snow
 * @since 2022/06/05
 */
@Target({ElementType.FIELD}) // 只能用在字段上
@Retention(RetentionPolicy.RUNTIME) // 声明生命周期，保留到运行时
public @interface SfTestField {
}
