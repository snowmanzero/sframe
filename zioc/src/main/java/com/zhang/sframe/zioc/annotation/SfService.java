package com.zhang.sframe.zioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识是个Service服务。
 *
 * @author snow
 * @date 2022/05/26
 */
@SfBean // 继承SfBean
@Target({ElementType.TYPE}) // 只能用在类上
@Retention(RetentionPolicy.RUNTIME) // 声明生命周期，保留到运行时
public @interface SfService {
}
