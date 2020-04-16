package com;

import com.member.sonar.base.Base2;
import org.testng.annotations.Test;

public class ATest {

    @Test
    public void baseTest() {
        Base2 base = new Base2();
        String result = base.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
