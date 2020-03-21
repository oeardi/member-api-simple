package com.member.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_real_info
 *
 * @author Administrator
 */
@Data
public class RealInfo implements Serializable {

    private static final long serialVersionUID = -7908602244670735146L;

    private Integer realAuthId;
    private Integer memberId;
    private String userName;
    private String mobilePhone;
    private String certNum;
    private String bankNum;
    private Date create_time;
    private Date update_time;
    private String appId;
    private String mid;
    private Integer status;
}
