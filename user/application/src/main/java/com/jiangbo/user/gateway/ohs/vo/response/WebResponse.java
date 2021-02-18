package com.jiangbo.user.gateway.ohs.vo.response;

import com.jiangbo.user.gateway.ohs.enums.WebStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ResponseBean
 *
 * @Author chengjianbo@shandiantech.com
 * @Date 2020/05/09
 * @Version 1.0.0
 *
 * @param <T>
 */
@ApiModel(value = "统一响应对象")
@Data
public class WebResponse<T> {

    /**
     * 响应业务码
     */
    @ApiModelProperty(value = "响应业务码")
    private int code;

    /**
     * 响应描述
     */
    @ApiModelProperty(value = "响应描述")
    private String msg;

    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * 构造函数
     * @param code
     * @param msg
     */
    public WebResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造函数
     * @param t
     */
    public WebResponse(T t) {
        this.code = WebStatusEnum.SUCCESS.getCode();
        this.data = t;
    }

    /**
     * 构造函数
     * @param errorMsg
     */
    public WebResponse(String errorMsg) {
        this.code = WebStatusEnum.SERVER_ERROR.getCode();
        this.msg = errorMsg;
    }

    /**
     * 返回成功有参响应对象
     * @param t
     * @param <T>
     * @return
     */
    public static <T> WebResponse<T> success(T t) {
        return new WebResponse<T>(t);
    }

    /**
     * 返回成功的无参响应对象
     * @return
     */
    public static WebResponse success() {
        return new WebResponse(WebStatusEnum.SUCCESS.getCode());
    }

    /**
     * 返回成功的自定义响应描述
     * @return
     */
    public static WebResponse success(String message) {
        return new WebResponse(WebStatusEnum.SUCCESS.getCode(), message);
    }

    /**
     * 根据错误消息返回对应的响应对象
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> WebResponse<T> fail(String errorMsg) {
        return new WebResponse<T>(errorMsg);
    }

    /**
     * 根据参数返回对应的响应对象
     * @param code
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> WebResponse<T> fail(int code, String errorMsg) {
        return new WebResponse<T>(code, errorMsg);
    }

    /**
     * 根据statusCode返回对应响应对象
     * @param authenticationFailed
     * @param <T>
     * @return
     */
    public static <T> WebResponse fail(WebStatusEnum authenticationFailed) {
        return new WebResponse<T>(authenticationFailed.getCode(), authenticationFailed.getMessage());
    }
}
