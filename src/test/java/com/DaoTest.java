package com;

import com.member.sonar.dao.Dao;
import org.testng.annotations.Test;

/**
 * @author 冷枫红舞
 */
public class DaoTest {

    @Test
    public void daoTest(){
        Dao dao = new Dao();
        String result = dao.getString();
        System.out.println("[Test Case] result = " + result);
    }
}
