package com.jiangbo.user.gateway.acl.repositories;

import com.jiangbo.user.domain.entity.Account;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * AccountMapper
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */

@org.apache.ibatis.annotations.Mapper
public interface AccountMapper extends Mapper<Account> {
  int batchUpdate(Account account);

  int updateByName(Account account);

  int updateByAge(Account account);

}
