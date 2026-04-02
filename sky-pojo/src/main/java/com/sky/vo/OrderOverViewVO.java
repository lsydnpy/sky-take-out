package com.sky.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单概览数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "订单概览数据视图对象")
public class OrderOverViewVO implements Serializable {
    @ApiModelProperty("待接单数量")
    private Integer waitingOrders;

    @ApiModelProperty("待派送数量")
    private Integer deliveredOrders;

    @ApiModelProperty("已完成数量")
    private Integer completedOrders;

    @ApiModelProperty("已取消数量")
    private Integer cancelledOrders;

    @ApiModelProperty("全部订单")
    private Integer allOrders;
}
