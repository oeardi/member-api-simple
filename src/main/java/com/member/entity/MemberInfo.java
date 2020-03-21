package com.member.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_member_info 实体类
 *
 * @author 冷枫红舞
 */
@Data
public class MemberInfo implements Serializable {

    private static final long serialVersionUID = 6098390956425756472L;

    private Integer memberId;
    private String memberName;
    private Integer memberType;
    private String password;
    private Integer age;
    private Integer sex;
    private String mobilePhone;
    private Integer actionFlag;
    private String appId;
    private String mid;
    private Integer isReal;
    private Integer status;
    private String businessId;
    private String comment;
    private Date create_time;
    private Date update_time;
}
