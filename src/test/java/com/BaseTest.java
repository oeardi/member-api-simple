package com;

import com.member.sonar.base.Base;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void baseTest() {
        Base base = new Base();
        String result = base.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
