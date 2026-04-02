package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 套餐总览
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "套餐总览视图对象")
public class SetmealOverViewVO implements Serializable {
    @ApiModelProperty("已启售数量")
    private Integer sold;

    @ApiModelProperty("已停售数量")
    private Integer discontinued;
}
