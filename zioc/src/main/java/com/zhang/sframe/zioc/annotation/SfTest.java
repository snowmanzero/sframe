package com.zhang.sframe.zioc.annotation;

import java.lang.annotation.*;

/**
 * @author snow
 * @since 2022/05/26
 */
@SfBean
@Target({ElementType.TYPE}) // 只能用在类上
@Retention(RetentionPolicy.RUNTIME) // 声明生命周期，保留到运行时
public @interface SfTest {

}
