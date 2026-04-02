package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "销量Top10报表视图对象")
public class SalesTop10ReportVO implements Serializable {

    @ApiModelProperty("商品名称列表，以逗号分隔，例如：鱼香肉丝,宫保鸡丁,水煮鱼")
    private String nameList;

    @ApiModelProperty("销量列表，以逗号分隔，例如：260,215,200")
    private String numberList;

}
