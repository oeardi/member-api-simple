package com.member.sonar.base;

import org.testng.annotations.Test;

public class SonarBase1Test {

    @Test
    public void sonarbase3() {
        SonarBase3 sonarBase3 = new SonarBase3();
        String result = sonarBase3.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
