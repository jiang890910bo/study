package com.jiangbo.user.domain.entity;

import com.jiangbo.user.enums.OrcusOrderStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单额外信息
 *
 * @author yeqi
 * @date 2019-07-22 16:05:14
 */
@Data
public class OrderExtraInfo implements Serializable {

  private static final long serialVersionUID = -7927306497008788320L;

  /**
   * 运力到乘客的距离（m）
   */
  private Integer distance;

  /**
   * 运力到乘客的时间（s）
   */
  private Integer duration;

  /**
   * 车辆编号
   */
  private String carNo;

  /**
   * 流量方订单编号
   */
  private String providerOrderNo;

  /**
   * 品牌id
   */
  private String appId;

  /**
   * 订单号
   */
  private String orderNo;

  /**
   * 司机编号
   */
  private String driverNo;

  /**
   * 询价单编号
   */
  private String inquiryOrderNo;

  /**
   * 流量方编号
   */
  private String providerNo;

  /**
   * 出发地地址
   */
  private String startAddr;

  /**
   * 出发地经度
   */
  private Double startLon;

  /**
   * 出发地纬度
   */
  private Double startLat;

  /**
   * 目的地地址
   */
  private String endAddr;

  /**
   * 目的地经度
   */
  private Double endLon;

  /**
   * 目的地纬度
   */
  private Double endLat;

  /**
   * 城市行政编码
   */
  private String cityCode;

  /**
   * 城市名称
   */
  private String cityName;

  /**
   * 业务类型
   */
  private String businessTypeCode;

  /**
   * 业务类型描述
   */
  private String businessTypeShow;

  /**
   * 运力类型
   */
  private String capacityTypeCode;

  /**
   * 运力类型描述
   */
  private String capacityTypeShow;

  /**
   * 预估时间，单位秒（s）
   */
  private Integer planUseTime;

  /**
   * 预估行驶距离，单位米（m）
   */
  private Integer planMileage;

  /**
   * 预估总价格，单位（分）
   */
  private Integer planTotalAmount;

  /**
   * 起步价，单位（分）
   */
  private Integer planStartFare;

  /**
   * 远途费，单位（分）
   */
  private Integer planLongDistanceFare;

  /**
   * 高峰期加价，单位（分）
   */
  private Integer planPeakTimeFare;

  /**
   * 特殊时段费，单位（分）
   */
  private Integer planOtherPeakTimeFare;

  /**
   * 里程费，单位（分）
   */
  private Integer planMileageFare;

  /**
   * 时长费，单位（分）
   */
  private Integer planTimeFare;

  /**
   * 预估其他费用，单位（分）
   */
  private Integer planOtherFare;

  /**
   * 计费规则Id
   */
  private Long fareRuleId;

  /**
   * 询价单状态，0:询价，1：抢单失败，2：抢单成功
   */
  private Integer status;

  /**
   * 询价单状态描述
   */
  private String statusShow;

  /**
   * 乘客下单时间
   */
  private Long publishOrderTime;

  /**
   * 平台调度抢单时间
   */
  private Long robOrderTime;

  /**
   * 订单归属时间
   */
  private Long orderBelongTime;

  /**
   * 乘客姓名
   */
  private String passengerName;

  /**
   * 乘客编号
   */
  private String passengerNo;

  /**
   * 乘客电话
   */
  private String passengerPhone;

  /**
   * 乘客虚拟电话
   */
  private String passengerVirtualMobile;

  /**
   * 订单类型
   */
  private String orderType;

  /**
   * 订单类型描述
   */
  private String orderTypeShow;

  // 属性待扩展...

  /**
   * 订单状态
   */
  private OrcusOrderStatus orcusOrderStatus;
}
