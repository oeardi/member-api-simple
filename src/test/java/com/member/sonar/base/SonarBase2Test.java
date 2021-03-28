package com.member.sonar.base;

import org.testng.annotations.Test;

public class SonarBase2Test {

    @Test
    public void sonarbase2() {
        SonarBase2 sonarBase2 = new SonarBase2();
        String result = sonarBase2.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
