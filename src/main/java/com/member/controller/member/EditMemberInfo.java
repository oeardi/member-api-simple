package com.member.controller.member;

import com.member.entity.MemberInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author difeng
 */
@ApiModel(value = "/", description = "编辑会员接口")
@RequestMapping(value = "v3")
@RestController
public class EditMemberInfo {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @ApiOperation(value = "编辑会员接口 - 根据传入对象的 member_id 字段修改任意其他字段数据 - SQL 使用 member_info-mapper.xml 中的 updateMemberInfoAnyFieldByMemberId", httpMethod = "POST")
    @RequestMapping(value = "/editMemberInfo", method = RequestMethod.POST)
    public String editMemberInfo(@RequestBody MemberInfo memberInfo) {

        int result = sqlSessionTemplate.update("updateMemberInfoAnyFieldByMemberId", memberInfo);

        if (result <= 0) {
            return "editMemberInfo ... failed";
        }
        return "editMemberInfo ... success: " + memberInfo.toString();
    }
}
