package com.zhang.sframe.zioc.annotation;

import java.lang.annotation.*;

/**
 * 标识是Bean。
 * 基础Bean注解，其他注解继承这个注解标识是个Bean。
 *
 * @author snow
 * @date 2022/05/27
 */
@Target({ElementType.TYPE}) // 只能用在类上
@Retention(RetentionPolicy.RUNTIME) // 声明生命周期，保留到运行时
public @interface SfBean {
}
