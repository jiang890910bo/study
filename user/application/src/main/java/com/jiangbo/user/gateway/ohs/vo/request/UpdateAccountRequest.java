package com.jiangbo.user.gateway.ohs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * UpdateAccountRequest
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Data
@ApiModel(value = "更新账户请求对象")
public class UpdateAccountRequest {

  @ApiModelProperty(value = "名字")
  @NotNull(message = "id不能为空")
  public Long id;

  @ApiModelProperty(value = "名字")
  @Size( max = 30)
  private String name;

  @ApiModelProperty(value = "年龄")
  @Max( value = 150)
  private Integer age;

  @ApiModelProperty(value = "存款")
  private Float deposit;

  private List<Long> idList;
}
