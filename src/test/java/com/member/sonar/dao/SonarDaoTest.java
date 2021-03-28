package com.member.sonar.dao;

import org.testng.annotations.Test;

/**
 * @author 冷枫红舞
 */
public class SonarDaoTest {

    @Test
    public void sonardao(){
        SonarDao dao = new SonarDao();
        String result = dao.getString();
        System.out.println("[Test Case] result = " + result);
    }
}
