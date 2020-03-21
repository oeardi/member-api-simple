package com;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * BaseTest 只实现 SpringBoot 和 TestNG 的整合，其他测试类只需要继承 BaseTest.java 类即可。
 *
 * @author difeng
 */
@SpringBootTest(classes = Application.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

}
