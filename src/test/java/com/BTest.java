package com;

import com.member.sonar.base.Base6;
import org.testng.annotations.Test;

public class BTest {

    @Test
    public void baseTest() {
        Base6 base = new Base6();
        String result = base.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
