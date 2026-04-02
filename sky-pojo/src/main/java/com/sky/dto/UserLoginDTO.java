package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
@ApiModel(description = "用户登录数据传输对象")
public class UserLoginDTO implements Serializable {

    @ApiModelProperty("微信登录code")
    private String code;

}
