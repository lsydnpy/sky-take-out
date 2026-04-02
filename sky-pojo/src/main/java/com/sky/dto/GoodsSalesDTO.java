package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "商品销售数据传输对象")
public class GoodsSalesDTO implements Serializable {
    //商品名称
    @ApiModelProperty("商品名称")
    private String name;

    //销量
    @ApiModelProperty("销量")
    private Integer number;
}
