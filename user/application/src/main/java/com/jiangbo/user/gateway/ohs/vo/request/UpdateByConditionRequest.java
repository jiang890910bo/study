package com.jiangbo.user.gateway.ohs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * UpdateByConditionRequest
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@ApiModel
@Data
@Builder
public class UpdateByConditionRequest {
  @ApiModelProperty(value = "名字")
  @Size( max = 30)
  private String name;

  @ApiModelProperty(value = "年龄")
  @Max( value = 150)
  private Integer age;

  @ApiModelProperty(value = "存款")
  private Float deposit;
}
