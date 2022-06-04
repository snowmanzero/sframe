package com.zhang.sframe.zcommon.verify.util;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 集合工具类
 *
 * @author snow
 * @since 2022/05/26
 */
public class CollectionUtil {
    public static boolean isEmpty(Collection collection) {
        return Objects.isNull(collection) || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<? extends Object, ? extends Object> map) {
        return Objects.isNull(map) || map.size() == 0;
    }

    public static boolean isNotEmpty(Map<? extends Object, ? extends Object> map) {
        return !isEmpty(map);
    }


}
