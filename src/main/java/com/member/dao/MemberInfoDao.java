package com.member.dao;

import com.member.entity.MemberInfo;

import java.util.List;

/**
 * 会员信息实体类
 *
 * @author 冷枫红舞
 */
public interface MemberInfoDao {

    /**
     * 会员注册
     *
     * @param memberInfo
     * @return
     */
    Integer insertMemberInfo(MemberInfo memberInfo);

    /**
     * 删除会员 - 根据 memberId 删除
     *
     * @param memberId
     * @return
     */
    Integer deleteMemberInfoByMemberId(Integer memberId);

    /**
     * 修改会员信息 - 根据 memberId 修改
     *
     * @param memberInfo
     * @return
     */
    Integer updateMemberInfoByMemberId(MemberInfo memberInfo);

    /**
     * 修改会员状态 - 根据 memberId 修改
     *
     * @param memberId
     * @param status
     * @return
     */
    Integer updateStatusByMemberId(Integer memberId, Integer status);

    /**
     * 查询会员信息 - 根据 memberId 查询
     *
     * @param memberId
     * @return
     */
    MemberInfo selectMemberInfoByMemberId(Integer memberId);

    /**
     * 查询会员信息 - 根据任意字段查询
     *
     * @param memberInfo
     * @return
     */
    List<MemberInfo> selectMemberInfoByAnyField(MemberInfo memberInfo);

    /**
     * 查询 mobile_phone 是否存在 - 根据 mobilePhone 查询
     *
     * @param mobilePhone
     * @return
     */
    Integer selectCountMemberInfoByMobilePhone(String mobilePhone);

    /**
     * 查询会员状态 - 根据 memberId 查询
     *
     * @param memberId
     * @return
     */
    Integer selectStatusByMemberId(Integer memberId);

}
