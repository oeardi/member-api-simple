package com.member.controller.member;

import com.member.entity.MemberInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * findMemberInfoByMemberId
 * findMemberInfo
 * findMemberInfo_return_JSONObject
 * findMemberInfo_return_JSONArray
 *
 * @author difeng
 */
@ApiModel(value = "/", description = "查询会员接口")
@RequestMapping(value = "v3")
@RestController
public class FindMemberInfo {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据 member_info 表的 member_id 字段进行查询 - 用于练习 HttpClient 的 UrlEncodedFormEntity 实体
     * <p>
     * 使用 sqlSessionTemplate.selectOne() 返回唯一记录，返回多条记录会报错：
     * "message": "nested exception is org.apache.ibatis.exceptions.TooManyResultsException:
     * Expected one result (or null) to be returned by selectOne(), but found: 3"
     * （使用了 selectOne，但是找到 3 条记录）
     *
     * @param memberId
     * @return
     */
    @ApiOperation(value = "查询会员接口（selectOne）- 根据 memberId 查询 - mapper 使用 findMemberInfoByMemberId", httpMethod = "POST")
    @RequestMapping(value = "/findMemberInfoByMemberId", method = RequestMethod.POST)
    @ResponseBody
    public Object findMemberInfoByMemberId(@RequestParam Integer memberId) {

        MemberInfo memberInfo = sqlSessionTemplate.selectOne("selectMemberInfoByMemberId", memberId);

        if (Objects.isNull(memberInfo)) {
            return "findMemberInfoByMemberId ... failed";
        }
        return memberInfo;
    }

    /**
     * 根据 member_info 表的任意字段查询 - 用于练习 HttpClient 的 StringEntity 实体
     * <p>
     * 使用 sqlSessionTemplate.selectOne() 返回唯一记录，返回多条记录会报错：
     * "message": "nested exception is org.apache.ibatis.exceptions.TooManyResultsException:
     * Expected one result (or null) to be returned by selectOne(), but found: 3"
     * （使用了 selectOne，但是找到 3 条记录）
     *
     * @param memberInfo
     * @return
     */
    @ApiOperation(value = "查询会员接口（selectOne）- 根据任意字段查询 - mapper 使用 selectMemberInfoByAnyField", httpMethod = "POST")
    @RequestMapping(value = "/findMemberInfoByAnyFieldReturnOne", method = RequestMethod.POST)
    @ResponseBody
    public MemberInfo findMemberInfoByAnyFieldReturnOne(@RequestBody MemberInfo memberInfo) {

        memberInfo = sqlSessionTemplate.selectOne("selectMemberInfoByAnyField", memberInfo);

        System.out.println(memberInfo.toString());

//        if (Objects.isNull(memberInfo)) {
//            return "findMemberInfoByMemberId ... failed";
//        }
        return memberInfo;
    }

    /**
     * 根据 member_info 表的任意字段查询 - 使用 sqlSessionTemplate.selectList() 返回多条记录
     *
     * @param memberInfo
     * @return
     */
    @ApiOperation(value = "查询会员接口（selectList）- 根据任意字段查询 - mapper 使用 selectMemberInfoByAnyField", httpMethod = "POST")
    @RequestMapping(value = "/findMemberInfoByAnyFieldReturnList", method = RequestMethod.POST)
    @ResponseBody
    public Object findMemberInfoByAnyFieldReturnList(@RequestBody MemberInfo memberInfo) {

        List<MemberInfo> memberInfoList = sqlSessionTemplate.selectList("selectMemberInfoByAnyField", memberInfo);

        System.out.println(memberInfoList.toString());

        if (Objects.isNull(memberInfoList)) {
            return "findMemberInfoByAnyField ... failed";
        }
        return memberInfoList;
    }


    /**
     * 根据 member_info 表的任意字段查询 - 使用 sqlSessionTemplate.selectList() 返回多条记录
     *
     * @param memberInfo
     * @return
     */
    @ApiOperation(value = "查询会员接口（selectList）- 根据任意字段查询 - mapper 使用 selectMemberInfoByAnyField", httpMethod = "POST")
    @RequestMapping(value = "/findMemberInfo_return_JSONArray", method = RequestMethod.POST)
    @ResponseBody
    public Object findMemberInfo_return_JSONArray(@RequestBody MemberInfo memberInfo) {

        /**
         * sqlSessionTemplate.selectList 返回 List
         */
        List<MemberInfo> memberInfoList = sqlSessionTemplate.selectList("selectMemberInfoByAnyField", memberInfo);

        return memberInfoList;
    }

}
