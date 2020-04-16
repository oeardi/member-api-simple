package com.member.sonar.service;

import com.member.sonar.dao.Dao;

/**
 * @author 冷枫红舞
 */
public class Service {

    public String getString() {
        Dao dao = new Dao();
        return dao.getString();
    }
}
