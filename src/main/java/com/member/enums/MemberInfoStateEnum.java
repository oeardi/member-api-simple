package com.member.enums;

/**
 * @author difeng
 */
public enum MemberInfoStateEnum {

    /**
     *
     */
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法信息"),
    SUCCESS(1, "操作成功"),
    PASS(2, "审核通过"),
    NULL_MEMBER_ID(-1001, "memberId 为空"),
    NULL_MEMBER_INFO(-1002, "MemberInfo 为空"),
    INNER_ERROR(9999, "内部系统错误");

    private Integer state;
    private String stateInfo;

    MemberInfoStateEnum(Integer state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}
