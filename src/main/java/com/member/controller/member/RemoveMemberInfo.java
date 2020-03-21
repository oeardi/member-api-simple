package com.member.controller.member;

import com.member.entity.MemberInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author difeng
 */
@ApiModel(value = "/", description = "删除会员接口")
@RequestMapping(value = "v3")
@RestController
public class RemoveMemberInfo {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据 member_id 删除
     *
     * @param member_id
     * @return
     */
    @ApiOperation(value = "根据 member_info 表的 member_id 字段删除 - mapper 使用 deleteMemberInfoByMemberId", httpMethod = "POST")
    @RequestMapping(value = "/removeMemberInfoByMemberId", method = RequestMethod.POST)
    public String removeMemberInfoByMemberId(@RequestParam String member_id) {

        int result = sqlSessionTemplate.delete("deleteMemberInfoByMemberId", member_id);
        System.out.println("[Test Case] result = " + result);

        if (result <= 0) {
            return "failed";
        }

        return "success";
    }

    /**
     * 根据任意字段删除
     *
     * @param memberInfo
     * @return
     */
    @ApiOperation(value = "根据 member_info 表的任意字段删除 - mapper 使用 deleteMemberInfoByAnyField", httpMethod = "POST")
    @RequestMapping(value = "/removeMemberInfoByAnyField", method = RequestMethod.POST)
    public String removeMemberInfoByAnyField(@RequestBody MemberInfo memberInfo) {

        int result = sqlSessionTemplate.delete("deleteMemberInfoByAnyField", memberInfo);
        System.out.println("[Test Case] result = " + result);

        if (result <= 0) {
            return "failed";
        }

        return "success";
    }
}
