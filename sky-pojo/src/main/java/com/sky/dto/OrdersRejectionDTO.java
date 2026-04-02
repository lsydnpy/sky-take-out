package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "订单拒绝数据传输对象")
public class OrdersRejectionDTO implements Serializable {

    @ApiModelProperty("订单ID")
    private Long id;

    //订单拒绝原因
    @ApiModelProperty("订单拒绝原因")
    private String rejectionReason;

}
