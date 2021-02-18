package com.jiangbo.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 订单预估事件请求对象
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/01
 */
@Setter
@Getter
@Accessors(chain = true)
public class OrderEstimateEventRequest {
  /**
   * 城市ID
   */
  @JSONField(name = "city_id")
  private String cityCode;
  /**
   * 三方预估ID
   */
  @JSONField(name = "bubble_id")
  private String bubbleId;
  /**
   * 冒泡时间戳
   */
  @JsonProperty(value = "bubble_time", required = true)
  private Long bubbleTime;
  /**
   * 坐标类型
   *
   * 1:百度
   *
   * 2:SOSOGCJ
   *
   * 3:WGS84
   */
  @JsonProperty(value = "coords_type", required = true)
  private Integer coordsType;
  /**
   * 预估时的纬度
   */
  @JsonProperty(value = "current_lat", required = true)
  private Double currentLat;
  /**
   * 预估时的经度
   */
  @JsonProperty(value = "current_lng", required = true)
  private Double currentLng;
  /**
   * 目的地纬度
   */
  @JsonProperty(value = "dest_lat", required = true)
  private Double destLat;
  /**
   * 目的地经度
   */
  @JsonProperty(value = "dest_lng", required = true)
  private Double destLng;
  /**
   * 出发地纬度
   */
  @JsonProperty(value = "starting_lat", required = true)
  private Double startingLat;
  /**
   * 出发地经度
   */
  @JsonProperty(value = "starting_lng", required = true)
  private Double startingLng;
  /**
   * 预估行驶距离 单位：米
   */
  @JsonProperty(value = "estimate_distance_metre")
  private Integer estimateDistanceMetre;
  /**
   * 预估价格 单位：元
   */
  @JsonProperty(value = "estimate_fee")
  private Double estimateFee;
  /**
   * 预估行驶时间 单位：分钟
   */
  @JsonProperty(value = "estimate_time_minutes")
  private Integer estimateTimeMinutes;
  /**
   * 乘客ID
   */
  @JsonProperty(value = "passenger_id", required = true)
  private String passengerId;
  /**
   * 乘客手机号
   */
  @JsonProperty(value = "passenger_phone")
  private String passengerPhone;
}
