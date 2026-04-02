package com.sky.dto;

import com.sky.entity.OrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel(description = "订单数据传输对象")
public class OrdersDTO implements Serializable {

    @ApiModelProperty("订单ID")
    private Long id;

    //订单号
    @ApiModelProperty("订单号")
    private String number;

    //订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
    @ApiModelProperty("订单状态 1待付款，2待派送，3已派送，4已完成，5已取消")
    private Integer status;

    //下单用户id
    @ApiModelProperty("下单用户ID")
    private Long userId;

    //地址id
    @ApiModelProperty("地址ID")
    private Long addressBookId;

    //下单时间
    @ApiModelProperty("下单时间")
    private LocalDateTime orderTime;

    //结账时间
    @ApiModelProperty("结账时间")
    private LocalDateTime checkoutTime;

    //支付方式 1微信，2支付宝
    @ApiModelProperty("支付方式 1微信，2支付宝")
    private Integer payMethod;

    //实收金额
    @ApiModelProperty("实收金额")
    private BigDecimal amount;

    //备注
    @ApiModelProperty("备注")
    private String remark;

    //用户名
    @ApiModelProperty("用户名")
    private String userName;

    //手机号
    @ApiModelProperty("手机号")
    private String phone;

    //地址
    @ApiModelProperty("地址")
    private String address;

    //收货人
    @ApiModelProperty("收货人")
    private String consignee;

    @ApiModelProperty("订单详情列表")
    private List<OrderDetail> orderDetails;

}
