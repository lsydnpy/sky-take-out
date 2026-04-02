package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "套餐分页查询数据传输对象")
public class SetmealPageQueryDTO implements Serializable {

    @ApiModelProperty("页码")
    private int page;

    @ApiModelProperty("每页大小")
    private int pageSize;

    @ApiModelProperty("套餐名称")
    private String name;

    //分类id
    @ApiModelProperty("分类ID")
    private Integer categoryId;

    //状态 0表示禁用 1表示启用
    @ApiModelProperty("状态 0表示禁用 1表示启用")
    private Integer status;

}
