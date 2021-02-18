package com.jiangbo.user.gateway.ohs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @date 2019/6/25
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public enum WebStatusEnum {

    /**
     * Success Ok
     */
    SUCCESS(200, "Success Ok"),

    /**
     * Server Error
     */
    PARAMETERS_ERROR(400, "parameters Error"),

    /**
     * Server Error
     */
    SERVER_ERROR(500, "Server Error"),

    /**
     * 鉴权失败(与gateway工程的错误码保持一致)
     */
    AUTHENTICATION_FAILED(998, "账号登录已失效"),

    /**
     * 下线处理(与gateway工程的错误码保持一致)
     */
    OFFLINE_DISPOSE(999, "账号在其他设备登陆"),

    /**
     * 司机已注册
     */
    DRIVER_REGISTERED(100005, "您已经注册过了"),
    /**
     * 邀请已提醒
     */
    TODAY_ALREADY_REMIND(100006, "今天已提醒过了"),
    /**
     * 短信验证码错误
     */
    SMS_CODE_ERROR(100007, "验证码错误, 今天仅剩%s次"),
    /**
     * 当前手机号今日不可登录
     */
    SMS_CODE_COUNT_LIMIT(100008, "当前手机号今日不可登录"),
    /**
     * 司机接收邀请注册成功
     */
    DRIVER_ACCEPT_INVITE_REGISTER_SUCCESS(100009, "注册成功");

    /**
     * 业务码
     */
    private int code;

    /**
     * 业务描述
     */
    private String message;

}
