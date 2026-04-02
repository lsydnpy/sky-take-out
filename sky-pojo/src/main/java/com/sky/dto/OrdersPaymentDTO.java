package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
@ApiModel(description = "订单支付数据传输对象")
public class OrdersPaymentDTO implements Serializable {
    //订单号
    @ApiModelProperty("订单号")
    private String orderNumber;

    //付款方式
    @ApiModelProperty("付款方式")
    private Integer payMethod;

}
