package com.jiangbo.user.gateway.ohs.controller;

import com.jiangbo.user.application.AccountConfigService;
import com.jiangbo.user.application.AccountService;
import com.jiangbo.user.config.AccountBaseConfig;
import com.jiangbo.user.gateway.ohs.vo.request.AccountRequest;
import com.jiangbo.user.gateway.ohs.vo.request.UpdateAccountRequest;
import com.jiangbo.user.gateway.ohs.vo.response.WebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * AccountController
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Api("账户操作接口")
@RestController
@RequestMapping(name = "/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  private String[] surnames = {"赵","钱","孙","李","周","吴","郑","王",
    "冯","陈","褚","卫","蒋","沈","韩","杨",
    "朱","秦","尤","许","何","吕","施","张",
    "孔","曹","严","华","金","魏","陶","姜",
    "戚","谢","邹","喻","柏","水","窦","章",
    "云","苏","潘","葛","奚","范","彭","郎",
    "鲁","韦","昌","马","苗","凤","花","方",
    "俞","任","袁","柳","酆","鲍","史","唐",
    "费","廉","岑","薛","雷","贺","倪","汤"};

  ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, Runtime.getRuntime().availableProcessors() * 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

  /**
   * 根据名字查询账号
   * @param name
   * @return
   */
  @ApiOperation("根据名字查询账号")
  @GetMapping(value = "/getByName")
  public WebResponse<AccountBaseConfig> getByName(@ApiParam(required = true) @RequestParam(value = "name") String name){
    return  WebResponse.success(AccountConfigService.getAccountConfig(name));
  }

  /**
   * 添加账户
   * @param request
   * @return
   */
  @ApiOperation("添加账户")
  @PostMapping(value = "/add")
  public WebResponse add(@Valid  @RequestBody  AccountRequest request){
    accountService.create(request);
    return WebResponse.success();
  }

  /**
   * 修改账户
   * @param request
   * @return
   */
  @ApiOperation("修改账户")
  @PostMapping(value = "/update")
  public WebResponse update(@Valid  @RequestBody  UpdateAccountRequest request) throws InterruptedException {
    accountService.updateById1(request);
    return WebResponse.success();
  }

  /**
   * 批量添加账户
   * @return
   */
  @ApiOperation("批量添加账户")
  @GetMapping(value = "/batchAdd")
  public WebResponse batchAdd() throws InterruptedException {
    executor.execute(
      () -> {
        for (int j = 0; j< 100000;  j++) {
          AccountRequest request1 = new AccountRequest();
          int index = new Random().nextInt(surnames.length);
          request1.setName(surnames[index] + Thread.currentThread().getName());
          request1.setAge(new Random().nextInt(50));
          request1.setDeposit(1000f);
          accountService.create(request1);
        }
      });



    return WebResponse.success();
  }
}
