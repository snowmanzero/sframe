package com.zhang.sframe.zioc.test.bean;

import com.zhang.sframe.zioc.annotation.SfAutowired;
import com.zhang.sframe.zioc.annotation.SfTest;
import com.zhang.sframe.zioc.test.dao.Game;

/**
 * Stu
 *
 * @author snow
 * @since 2022/06/05
 */
@SfTest
public class Stu extends User{
    private String name;

    @SfAutowired
    private Book book;

    @SfAutowired
    private Game game;

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", book=" + book +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
