package com.jiangbo.user.gateway.ohs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * AccountRequest
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Data
@ApiModel(value = "账户请求对象")
public class AccountRequest {

  @ApiModelProperty(value = "名字")
  @NotNull(message = "名字不能为空")
  @Size( max = 30)
  private String name;

  @ApiModelProperty(value = "年龄")
  @NotNull(message = "年龄不能为空")
  @Max( value = 150)
  private Integer age;

  @ApiModelProperty(value = "存款")
  @NotNull(message = "存款不能为空")
  private Float deposit;

	@ApiModelProperty(value = "序列号")
	@NotNull(message = "序列号不能为空")
  private String seq;
}
