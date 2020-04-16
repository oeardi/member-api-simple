package com.member.sonar.dao;

import com.member.sonar.base.Base;

/**
 * @author 冷枫红舞
 */
public class Dao {

    public String getString() {
        Base base = new Base();
        int num = Integer.valueOf(base.getString());

        int _n = 50;
        if (num < _n) {
            return "小于 50";
        } else {
            return "大于 50";
        }
    }

}
