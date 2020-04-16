package com.member;

import com.member.sonar.service.Service;
import org.testng.annotations.Test;

/**
 * @author 冷枫红舞
 */
public class SonarTest {

    @Test
    public void sonarTest() {
        Service service = new Service();
        String result = service.getString();
        System.out.println("[Test Case] result = " + result);
    }

    @Test
    public void sonarTest1() {
        Service service = new Service();
        String result = service.getString();
        System.out.println("[Test Case] result = " + result);
    }

    @Test
    public void sonarTest3() {
        Service service = new Service();
        String result = service.getString();
        System.out.println("[Test Case] result = " + result);
    }

}
