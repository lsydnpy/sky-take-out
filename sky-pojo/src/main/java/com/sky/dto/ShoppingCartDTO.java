package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
@ApiModel(description = "购物车数据传输对象")
public class ShoppingCartDTO implements Serializable {

    @ApiModelProperty("菜品ID")
    private Long dishId;
    @ApiModelProperty("套餐ID")
    private Long setmealId;
    @ApiModelProperty("菜品口味")
    private String dishFlavor;

}
