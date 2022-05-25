package com.zhang.sframe.zcommon.verify.util;

import java.util.Objects;

/**
 * 字符串工具类
 *
 * @author snow
 * @date 2022/05/25
 */
public class StringUtil {
    public static boolean isBlank(String string) {
        return Objects.isNull(string) || string.trim().length() == 0;
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }
}
