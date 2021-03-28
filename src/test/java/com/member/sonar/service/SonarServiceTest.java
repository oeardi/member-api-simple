package com.member.sonar.service;

import org.testng.annotations.Test;

/**
 * @author 冷枫红舞
 */
public class SonarServiceTest {

    @Test
    public void sonarservcie() {
        SonarService service = new SonarService();
        String str = "abc";
        String result = service.getString(str);
        System.out.println("[Test Case] result = " + result);
    }

    @Test
    public void sonarservcie1() {
        SonarService service = new SonarService();
        String str = "abc";
        String result = service.getString1(str);
        System.out.println("[Test Case] result = " + result);
    }

    @Test
    public void sonarservcie2() {
        SonarService service = new SonarService();
        String str = "abc";
        String result = service.getString2(str);
        System.out.println("[Test Case] result = " + result);
    }

}
