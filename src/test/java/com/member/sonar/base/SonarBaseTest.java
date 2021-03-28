package com.member.sonar.base;

import org.testng.annotations.Test;

public class SonarBaseTest {

    @Test
    public void sonarbase() {
        SonarBase sonarBase = new SonarBase();
        String result = sonarBase.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
