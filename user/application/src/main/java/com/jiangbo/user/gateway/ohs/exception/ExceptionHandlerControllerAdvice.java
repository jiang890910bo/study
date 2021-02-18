package com.jiangbo.user.gateway.ohs.exception;

import com.jiangbo.user.gateway.ohs.enums.WebStatusEnum;
import com.jiangbo.user.gateway.ohs.vo.response.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * 统一controller异常处理
 *
 * @Author chengjianbo@shandiantech.com
 * @Date 2020/05/09
 * @Version 1.0.0
 */
@Slf4j
@ControllerAdvice
@SuppressWarnings("LineLength")
public class ExceptionHandlerControllerAdvice {


  /**
   * 参数校验异常
   *
   * @param e 异常
   * @return 转换后的responseBean
   */
  @ResponseBody
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public WebResponse<?> methodArgumentNotValidExceptionHandler1(MethodArgumentNotValidException e) {
    List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
    String msg = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(";"));
    return WebResponse.fail(WebStatusEnum.PARAMETERS_ERROR.getCode(), msg);
  }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public WebResponse<?> methodArgumentNotValidExceptionHandler(BindException e) {
        final String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(joining(", "));
        return WebResponse.fail(WebStatusEnum.PARAMETERS_ERROR.getCode(), message);
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public WebResponse<?> methodArgumentNotValidExceptionHandler(ConstraintViolationException e) {
        final String message = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(joining(", "));

        return WebResponse.fail(WebStatusEnum.PARAMETERS_ERROR.getCode(), message);
    }


    /**
     * 统一异常处理
     *
     * @param e 异常
     * @return 转换后的responseBean
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public WebResponse exceptionHandler(Exception e) {
        log.warn(e.getMessage(), e);
        int code = WebStatusEnum.SERVER_ERROR.getCode();
        return WebResponse.fail(code, "系统繁忙，请稍后再试");
    }

}
