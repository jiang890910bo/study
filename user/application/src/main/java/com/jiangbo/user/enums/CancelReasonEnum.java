package com.jiangbo.user.enums;

/**
 * CancelReasonEnum
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/14
 * @Version 1.0.0
 */
public enum CancelReasonEnum {
  THIRD(1, "归属其他平台"),
  BACKSTAGE(2, "客服关单"),
  DRIVER(3, "司机取消"),
  PASSENGER(4, "应答后乘客取消"),
  MONITOR(5, "风控取消"),
  DISPATCH_FAILED(6, "派单失败"),
  PASSENGER_BEFORE(7, "应答前乘客取消"),
  OVER_TIME(8, "调度超时");

  private byte type;
  private String show;

  private CancelReasonEnum(int type, String show) {
    this.type = (byte)type;
    this.show = show;
  }

  public static CancelReasonEnum valueOf(Byte type) {
    if (type == null) {
      return THIRD;
    } else {
      CancelReasonEnum[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
        CancelReasonEnum value = var1[var3];
        if (value.type == type) {
          return value;
        }
      }

      return THIRD;
    }
  }

  public byte getType() {
    return this.type;
  }

  public String getShow() {
    return this.show;
  }
}
