package com.zhang.sframe.zioc.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * bean文件过滤器
 *
 * @author snow
 * @date 2022/05/25
 */
public class BeanFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        System.out.println("BeanFileFilter:" + file);
        return file.isDirectory() || file.getName().endsWith(".class");
    }
}
