package com.jiangbo.user.enums;

import lombok.Getter;

/**
 * TODO
 *
 * @author dopen
 * @version 1.0.0
 * @email ******@skio.cn
 * @date 2020/1/3
 * Modification  History:
 * Date         Author        Version        Description
 * ------------------------------------------------------
 * 2020/1/3    dopen       1.0.0          create
 */
@Getter
public enum OrcusOrderStatus {

  /**
   * 订单状态：根据订单系统额中的订单状态和取消状态生成
   */
  CREATED(0, "新建行程", OrderStatusEnum.CREATE),

  GO_PASSENGER(1, "去接乘客", OrderStatusEnum.GO_PASSENGER),
  WAIT_PASSENGER(2, "等待乘客上车", OrderStatusEnum.WAIT_PASSENGER),

  DURING(3, "行程中", OrderStatusEnum.DURING_TRIP),

  ENDING(4, "行程结束，待发起付款", OrderStatusEnum.UN_REQUEST_PAY),

  WAIT_PAY(5, "待乘客支付", OrderStatusEnum.UN_PAY),
  SUCCESS_PAY(6, "乘客支付完成", OrderStatusEnum.NORMAL_PAY),

  //  ADVANCE("平台代付", OrderStatusEnum.OTHER_PAY),

  EVALUATED(8, "已评价", OrderStatusEnum.EVALUATED),

  THIRD_CANCEL(9, "流量方取消、归属其他平台", CancelReasonEnum.THIRD),
  BACKSTAGE_CANCEL(9, "后台客服取消", CancelReasonEnum.BACKSTAGE),
  DRIVER_CANCEL(9, "司机取消", CancelReasonEnum.DRIVER),
  PASSENGER_CANCEL(9, "乘客取消、应答后乘客取消", CancelReasonEnum.PASSENGER),
  MONITOR_CANCEL(9, "风控取消", CancelReasonEnum.MONITOR),
  DISPATCH_FAILED_CANCEL(9, "派单失败", CancelReasonEnum.DISPATCH_FAILED),
  PASSENGER_BEFORE_CANCEL(9, "应答前乘客取消", CancelReasonEnum.PASSENGER_BEFORE),
  OVER_TIME_CANCEL(9, "调度超时", CancelReasonEnum.OVER_TIME);

  /**
   * 需要通知流量方取消订单 的订单状态
   */
  public static final OrcusOrderStatus[] NEED_NOTIFY_CANCEL_STATUS =
    {BACKSTAGE_CANCEL, DRIVER_CANCEL, MONITOR_CANCEL, DISPATCH_FAILED_CANCEL};

  /**
   * 需要上报位置的订单状态
   */
  public static final OrcusOrderStatus[] NEED_REPORT_LOCATION_STATUS =
    {CREATED, GO_PASSENGER, WAIT_PASSENGER, DURING};

  /**
   * 需要上报实时费用的订单状态
   */
  public static final OrcusOrderStatus[] NEED_REPORT_FEE_STATUS = {DURING};

  /**
   * 状态变更顺序
   */
  private int index;
  private String show;
  private OrderStatusEnum orderStatus;
  private CancelReasonEnum cancelReason;

  OrcusOrderStatus(int index, String show, OrderStatusEnum orderStatus) {
    this.index = index;
    this.show = show;
    this.orderStatus = orderStatus;
  }

  OrcusOrderStatus(int index, String show, CancelReasonEnum cancelReason) {
    this.index = index;
    this.show = show;
    this.cancelReason = cancelReason;
  }

  public static OrcusOrderStatus valueOf(OrderStatusEnum status) {
    for (OrcusOrderStatus value : values()) {
      if (value.orderStatus != null && value.orderStatus.equals(status)) {
        return value;
      }
    }
    return null;
  }

  public static OrcusOrderStatus valueOf(CancelReasonEnum reason) {
    for (OrcusOrderStatus value : values()) {
      if (value.cancelReason != null && value.cancelReason.equals(reason)) {
        return value;
      }
    }
    return null;
  }

}
