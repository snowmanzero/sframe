package com.zhang.sframe.zioc.test.bean;

import com.zhang.sframe.zioc.annotation.SfTest;

/**
 * Book
 *
 * @author snow
 * @since 2022/06/05
 */
@SfTest
public class Book {
    private String name = "java";

    private String store = "xinhau";


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

}
