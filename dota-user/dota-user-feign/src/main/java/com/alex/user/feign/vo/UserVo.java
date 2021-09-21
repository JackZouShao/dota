package com.alex.user.feign.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value = "UserVo", description = "UserVo1")
public class UserVo {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name= "", example = "1")
    private int currentPage;

    /**
     * 每页记录数
     */
    @ApiModelProperty(value = "页面大小", name= "", example = "1")
    private int pageSize;

    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 手机号码
     */
    private String phone_number;

    /**
     * 密码盐
     */
    private String mobileSalt;

    /**
     * wechat token
     */
    private String wechatToken;

    /**
     * steam token
     */
    private String steamToken;

    /**
     * 个人简介
     */
    private String userIntroduction;

    /**
     * 喜爱个数
     */
    private short favorites_count;

    /**
     * 发布帖子总数
     */
    private short post_count;

    /**
     * 性别
     */
    private boolean gender;

    /**
     * 背景图片地址
     */
    private String profileBackgroundImageURl;

    /**
     * 创建时间，展示用 ex: 2016年10月
     */
    private String createAt;
    }
