package com.member.controller.demo;

import com.member.entity.MemberInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author difeng
 */
@ApiModel(value = "/")
@RequestMapping(value = "v1")
@RestController
public class GetDemo {

    /**
     * 创建 SqlSessionTemplate 对象，用于执行 mybatis 提供的 insert delete update select 等方法
     *
     * @Autowired 由 spring 容器对类进行加载
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 1. 请求服务器 /index 主页，并获取到 cookies 信息
     *
     * @RequestMapping 参数说明：
     * 访问路径：value = "/index"
     * 请求方式：Get 请求，method = RequestMethod.GET
     */
    @ApiOperation(value = "1. 请求服务器 /index 主页，并获取到 cookies 信息", httpMethod = "GET")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletResponse response) {

        /**
         * 说明：
         * 函数原型：public String requestIndex(HttpServletResponse response)
         * requestIndex() 方法参数中的 HttpServletResponse 对象，是用于存放所有的“响应信息”的类。
         * 比如本例中，需要由“服务端”响应请求，并返回 cookies 信息，也就是由“服务端”返回（数据）给“前端”。
         * 所以需要创建 HttpServletResponse 对象，在 response 对象中添加数据，
         * 通过 url 请求之后，就可以通过浏览器的“F12”查看到响应数据的 cookies 信息。
         * --------------------
         * 扩展知识：
         * 除了 HttpServletResponse 对象（存放所有“响应信息”），
         * 还有一个可以作为参数的 HttpServletRequest 对象，用于存放所有的“请求信息”的类。
         */

        // 创建 Cookie 对象，并通过 response.addCookie() 方法存放 cookies 信息，将 cookies 信息返回给浏览器
        Cookie cookie = new Cookie("login", "success");
        response.addCookie(cookie);

        // 注：
        // return 的信息由我们随意编写，
        // 而由“服务端”返回的响应信息，（即：在浏览器 F12 中查看到的响应内容）
        // 则必须添加到 HttpServletResponse 对象当中。
        return "request and get cookies info success: name = " + cookie.getName() + "  value = " + cookie.getValue();
    }

    /**
     * 2. 登录（成功，返回登录成功和用户名）
     *
     * @RequestMapping 参数说明：
     * 访问路径：value = "/login"
     * 请求方式：Get 请求，method = RequestMethod.GET
     */
    @ApiOperation(value = "2. 登录（成功，返回登录成功和用户名）", httpMethod = "GET")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {
        // @RequestParam 标记，声明传入参数
        // value = "userName" 表示和“前端页面”传入的 userName 参数（名称）必须对应
        // required = true 表示“前端页面”必须传入这个参数（必传参数）

        /**
         * 实际项目中，name 和 pass 的值通常从数据库中获取
         */
        String name = "大侦探";
        String pass = "111111";

        // 校验用户名和密码
        if (username.equals(name) && password.equals(pass)) {

            // 登录成功，获取 cookies
            // 创建 Cookie 对象，将 cookies 信息通过 Response 对象返回给“前端”
            Cookie cookie = new Cookie("login", "success");
            response.addCookie(cookie);

            /**
             * 注：cookies 信息是通过 response 返回的
             */
            return "login success：" + username;
        }
        return "login failed：username or password error";
    }

    /**
     * 3. 查询 - 根据 member_id 查询用户信息
     *
     * @RequestMapping 参数说明：
     * 访问路径：value = "/getUserInfoById"
     * 请求方式：Get 请求，method = RequestMethod.GET
     */
    @ApiOperation(value = "3. 查询 - 根据 member_id 查询用户信息", httpMethod = "GET")
    @RequestMapping(value = "/findMemberInfoByMemberId", method = RequestMethod.GET)
    public String findMemberInfoByMemberId(@RequestParam String member_id) {

        MemberInfo memberInfo = sqlSessionTemplate.selectOne("selectMemberInfoByMemberId", member_id);

        /**
         * // Objects.isNull 由 JDK 1.8 提供
         */
        if (Objects.isNull(memberInfo)) {
            return "findMemberInfoByMemberId ... failed.";
        }

        return memberInfo.toString();
    }

    /**
     * 4. 删除 - 根据 member_id 删除用户信息
     *
     * @RequestMapping 参数说明：
     * 访问路径：value = "/removeMemberInfoByMemberId"
     * 请求方式：Get 请求，method = RequestMethod.GET
     * ----------
     * 方法参数说明：removeMemberInfoByMemberId()
     * 1. @RequestParam String member_id 传入用户名，用于 where 语句的条件
     * 2. statement 需要与 mapper.xml 映射文件中，对应 sql 语句的 id 相对应
     */
    @ApiOperation(value = "4. 删除 - 根据 userName 删除用户信息", httpMethod = "GET")
    @RequestMapping(value = "removeMemberInfoByMemberId", method = RequestMethod.GET)
    public String removeMemberInfoByMemberId(@RequestParam String member_id) {

        int result = sqlSessionTemplate.delete("deleteMemberInfoByMemberId", member_id);

        if (result <= 0) {
            return "deleteUserInfoByUserName ... failed";
        }
        return "deleteUserInfoByUserName ... success";
    }

    /**
     * 5. 查询 - 根据 sex 统计用户数量
     *
     * @RequestMapping 参数说明：
     * 访问路径：value = "/findMemberInfoCount"
     * 请求方式：Get 请求，method = RequestMethod.GET
     * ----------
     * 方法参数说明：getUserInfoCount()
     * 1. @RequestParam String sex 传入性别
     * 2. getUserInfoCount() 不需要参数
     */
    @ApiOperation(value = "5. 查询 - 根据 sex 统计用户数量", httpMethod = "GET")
    @RequestMapping(value = "/findMemberInfoCount", method = RequestMethod.GET)
    public String findMemberInfoCount(@RequestParam String sex) {

        int result = sqlSessionTemplate.selectOne("selectMemberInfoCountBySex", sex);

        if (result < 0) {
            System.out.println("findMemberInfoCount ... failed");
        }

        return "sex = " + sex + " count: " + result;
    }
}
