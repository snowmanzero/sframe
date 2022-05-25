package com.zhang.sframe.zcommon.util;

import java.io.File;

/**
 * 文件工具类
 *
 * @author snow
 * @date 2022/05/25
 */
public class FileUtil {
    /**
     * 获取文件名称。无后缀名的名称。
     * 例如：test11.class，返回test11。
     * @param filename 文件名称
     * @return 无后缀名的文件名称
     */
    public static String getNameWithoutSuffix(String filename) {
        return filename.substring(0, filename.lastIndexOf("."));
    }

    /**
     * 获取文件名称。无后缀名的名称。
     * 例如：test11.class，返回test11。
     * @param file 目标文件
     * @return 无后缀名的文件名称
     */
    public static String getNameWithoutSuffix(File file) {
        return getNameWithoutSuffix(file.getName());
    }
}
