package com.alex.common.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("用户")
public class UserInfo {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    @ApiModelProperty(value = "用户ID", dataType = "int" ,example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户代码",example = "123")
    private String userCode;

    private String userName;

    @ApiModelProperty("年龄")
    private Integer age;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}