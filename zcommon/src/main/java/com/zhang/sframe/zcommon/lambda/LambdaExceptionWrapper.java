package com.zhang.sframe.zcommon.lambda;

import java.util.function.Consumer;

/**
 * LambdaExceptionWrapper
 *
 * @author snow
 * @since 2022/06/04
 */
public class LambdaExceptionWrapper implements Consumer {
    public static <T, E extends Exception> Consumer<T> wrapper(Consumer<T> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
    }

//    public void accept(Class<?> item) {
//        try {
//            beanMap.put(item.getName().toLowerCase(Locale.US), item.newInstance());
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void accept(Object o) {

    }
}
