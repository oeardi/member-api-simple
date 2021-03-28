package com.member.sonar.dao;

import com.member.sonar.base.SonarBase;

/**
 * @author 冷枫红舞
 */
public class SonarDao {

    public String getString() {
        SonarBase base = new SonarBase();
        int num = Integer.valueOf(base.getString());

        int _n = 50;
        if (num < _n) {
            return "小于 50";
        } else {
            return "大于 50";
        }
    }

}
