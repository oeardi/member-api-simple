package com.member.sonar.base;

import org.testng.annotations.Test;

public class SonarBase3Test {

    @Test
    public void sonarbase1() {
        SonarBase sonarBase = new SonarBase();
        String result = sonarBase.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
