package com.zhang.sframe.zioc.test.dao.impl;

import com.zhang.sframe.zioc.annotation.SfTest;
import com.zhang.sframe.zioc.test.dao.Game;

/**
 * FootBall
 *
 * @author snow
 * @since 2022/06/05
 */
@SfTest
public class FootBall implements Game {
    @Override
    public void action() {
        System.out.println("play football");
    }
}
