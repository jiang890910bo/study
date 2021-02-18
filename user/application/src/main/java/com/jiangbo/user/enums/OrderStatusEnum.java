package com.jiangbo.user.enums;

/**
 * OrderStatusEnum
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/14
 * @Version 1.0.0
 */
public enum OrderStatusEnum {
  CREATE(0, "新建行程"),
  GO_PASSENGER(1, "去接乘客"),
  WAIT_PASSENGER(2, "等待乘客上车"),
  DURING_TRIP(3, "行程中"),
  UN_REQUEST_PAY(4, "待发起收款"),
  UN_PAY(5, "待乘客支付"),
  NORMAL_PAY(6, "乘客已支付"),
  EVALUATED(8, "已评价"),
  CANCEL(9, "订单关闭");

  private byte type;
  private String show;

  private OrderStatusEnum(int type, String show) {
    this.type = (byte)type;
    this.show = show;
  }

  public static OrderStatusEnum valueOf(Byte type) {
    if (type == null) {
      return CREATE;
    } else {
      OrderStatusEnum[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
        OrderStatusEnum value = var1[var3];
        if (value.type == type) {
          return value;
        }
      }

      return CREATE;
    }
  }

  public byte getType() {
    return this.type;
  }

  public String getShow() {
    return this.show;
  }
}
