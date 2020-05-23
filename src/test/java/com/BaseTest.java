package com;

import com.member.entity.MemberInfo;
import com.member.sonar.base.Base;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void baseTest() {
        Base base = new Base();
        String result = base.getString();
        System.out.println("[Test Case] result = " + result);
    }

    /**
     * 1. 练习 idea 插件 GenerateAllSetter 的使用
     * 1）MemberInfo memberInfo = new MemberInfo();
     * 2）在 memberInfo 按 alt + enter
     * <p>
     * 2. 练习 idea 插件 CamelCase 的使用
     * 1）在 memberInfo 按 shift + alt + u
     * <p>
     * 3. 练习 GsonFormat 插件的使用
     * 修改热键为 ctrl + alt + g
     */
    @Test
    public void testPlugin() {
        MemberInfo memberInfo = new MemberInfo();


    }

}
