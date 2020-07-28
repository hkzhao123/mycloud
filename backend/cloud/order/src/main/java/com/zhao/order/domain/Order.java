package com.zhao.order.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <h3>cloud</h3>
 * <p></p>
 *
 * @author : hkzhao
 * @date : 2020-07-23 22:23
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Order {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("商品ID")
    private Long productId;
    @ApiModelProperty("商品数量")
    private Integer count;
    @ApiModelProperty("商品单价")
    private BigDecimal money;
    @ApiModelProperty("订单状态")
    private Integer status;
}