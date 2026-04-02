package com.sky.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据概览
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "营业数据视图对象")
public class BusinessDataVO implements Serializable {

    @ApiModelProperty("营业额")
    private Double turnover;

    @ApiModelProperty("有效订单数")
    private Integer validOrderCount;

    @ApiModelProperty("订单完成率")
    private Double orderCompletionRate;

    @ApiModelProperty("平均客单价")
    private Double unitPrice;

    @ApiModelProperty("新增用户数")
    private Integer newUsers;

}
