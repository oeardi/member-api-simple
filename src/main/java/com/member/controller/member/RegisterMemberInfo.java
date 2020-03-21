package com.member.controller.member;

import com.member.entity.MemberInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author difeng
 */
@ApiModel(value = "/", description = "会员注册接口")
@RequestMapping(value = "v3")
@RestController
public class RegisterMemberInfo {

    Logger logger = LoggerFactory.getLogger(RegisterMemberInfo.class);

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @ApiOperation(value = "会员注册接口 - SQL 使用 mapper.xml 中的 insertMemberInfo", httpMethod = "POST")
    @RequestMapping(value = "/registerMemberInfo", method = RequestMethod.POST)
    public String registerMemberInfo(HttpServletResponse httpServletResponse, @RequestBody MemberInfo memberInfo) {

        /**
         * 添加 header 练习（registerHeader 和 setHeader）并提供给 HttpClient 测试代码练习获取 header（getHeader 和 getAllHeader）
         */

        /**
         * 添加请求头字段，如果 key 值重复，可以同时添加多个（类似于 List 集合）
         *
         * void registerHeader(String key, String value);
         */
        httpServletResponse.addHeader("diyHeader", "i'm, ni da ye.");
        httpServletResponse.addHeader("diyHeader", "i'm, ni da ye.");
        httpServletResponse.addHeader("header", "i'm, ni da ye.");

        /**
         * 设置请求头字段，如果 key 值重复，则覆盖；key 不存在，则新增。（类似与 Map 集合）
         *
         * void setHeader(String key, String value);
         */
        httpServletResponse.setHeader("myHeader", "i'm, ni da ye.");
        httpServletResponse.setHeader("myHeader", "i'm, ni qin da ye.");


        logger.info("[Test Case] memberInfo.getAppId() = " + memberInfo.getMemberId());
        int result = sqlSessionTemplate.insert("insertMemberInfo", memberInfo);
        logger.info("[Test Case] memberInfo.getAppId() = " + memberInfo.getMemberId());

        logger.debug("int result = sqlSessionTemplate.insert(\"registerMemberInfo\", memberInfo); " + result);
        logger.error("int result = sqlSessionTemplate.insert(\"registerMemberInfo\", memberInfo); " + result);

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();

        logger.info("costTime:[{}ms]", endTime - startTime);

        if (result <= 0) {
            return "registerMemberInfo ... failed";
        }

        return "registerMemberInfo ... success: " + memberInfo.toString();
    }
}
