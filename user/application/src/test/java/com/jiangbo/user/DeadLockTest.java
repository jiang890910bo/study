package com.jiangbo.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * DeadLockTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/23
 */

public class DeadLockTest {

  public static void main(String[] args) {
    int i = 1/0;
  }
}
