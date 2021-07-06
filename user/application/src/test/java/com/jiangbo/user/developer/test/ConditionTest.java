
package com.jiangbo.user.developer.test;

/**
 * ConditionTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/06/25
 */
public class ConditionTest {
	public static void main(String[] args) {
		if(("0".equals("0") || "1".equals("0")) && "1".equals("0")){
			System.out.println("相等");
		}else{
			System.out.println("不相等");
		}

		String cityCode="33101";
		String companyId="1101FDZH891N";
		if("33101".equals(cityCode) && ("3301HZJS8068".equals(companyId) || "5201DCCXTE11".equals(companyId) || "3501FJHW916U".equals(companyId))){
			System.out.println("相等");
		}


	}
}
