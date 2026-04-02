package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "密码修改数据传输对象")
public class PasswordEditDTO implements Serializable {

    //员工id
    @ApiModelProperty("员工ID")
    private Long empId;

    //旧密码
    @ApiModelProperty("旧密码")
    private String oldPassword;

    //新密码
    @ApiModelProperty("新密码")
    private String newPassword;

}
