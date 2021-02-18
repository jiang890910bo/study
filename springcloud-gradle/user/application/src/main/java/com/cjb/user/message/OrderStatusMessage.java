package com.cjb.user.message;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * OrderStatusMessage
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/13
 * @Version 1.0.0
 */
@Getter
@Setter
@ApiOperation(value = "订单状态消息对象")
public class OrderStatusMessage {

  /**
   * 订单编号
   */
  @ApiModelProperty(value = "订单编号")
  private String orderNo;
  /**
   * 品牌方Id
   */
  @ApiModelProperty(value = "品牌方Id")
  private String appId;

  /**
   * 状态变更时间
   */
  @ApiModelProperty(value = "状态变更时间")
  private Long changeTime;

  @ApiModelProperty(value = "定位类型，0:GPS，1:基站，2:其他")
  private String provider;

}
