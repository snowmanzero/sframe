package com.zhang.sframe.zioc.util;

import com.zhang.sframe.zcommon.constant.SpecialConst;
import com.zhang.sframe.zcommon.util.FileUtil;
import com.zhang.sframe.zcommon.verify.util.CollectionUtil;
import com.zhang.sframe.zcommon.verify.util.StringUtil;
import com.zhang.sframe.zioc.filter.ClassFileFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Bean工具类
 *
 * @author snow
 * @date 2022/05/25
 */
public class BeanUtil {
    public static List<Class<?>> getClasses(String packName) {

        String packPath = packName.replace(SpecialConst.Dot, SpecialConst.SLASH);
//        System.out.println("path:" + packPath);

        // 所有类集合
        List<Class<?>> allClasses = new ArrayList<>();
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packPath);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    // 根据class文件获取类
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    List<Class<?>> classes = getClassesByPackPath(packName, filePath);
                    if (CollectionUtil.isNotEmpty(classes)) {
                        allClasses.addAll(classes);
                    }
                } else if ("jar".equals(protocol)) {
                    // todo
                    List<Class<?>> classes = new ArrayList<>();
                    if (CollectionUtil.isNotEmpty(classes)) {
                        allClasses.addAll(classes);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (Class<?> clazz : allClasses) {
//            System.out.println(clazz);
//        }
        return allClasses;
    }

    private static List<Class<?>> getClassesByPackPath(String packName, String filePath) {
        if (StringUtil.isBlank(packName) || StringUtil.isBlank(filePath)) {
            return Collections.EMPTY_LIST;
        }

        File packFile = new File(filePath);
        if (!packFile.exists() || !packFile.isDirectory()) {
            return Collections.EMPTY_LIST;
        }

        List<Class<?>> clazzList = new ArrayList<>();
        for (File file : packFile.listFiles(new ClassFileFilter())) {
            if (!file.isDirectory()) {
                // 不是文件夹 说明是class文件
                String filename = FileUtil.getNameWithoutSuffix(file);
                try {
                    Class<?> clazz = Class.forName(String.join(SpecialConst.Dot, packName, filename));
                    clazzList.add(clazz);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                // 是文件夹 进入到文件夹中继续遍历
                String subPackName = String.join(SpecialConst.Dot, packName, file.getName());
                List<Class<?>> classes = getClassesByPackPath(subPackName, file.getAbsolutePath());
                if (CollectionUtil.isNotEmpty(classes)) {
                    clazzList.addAll(classes);
                }
            }
        }

        return clazzList;
    }
}
