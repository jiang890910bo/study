package com.jiangbo.user;

import lombok.Getter;

/**
 * EnumKnowTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/01/05
 */
public class EnumKnowTest {

	public static void main(String[] args) {
		ProviderIdEnum providerIdEnum = ProviderIdEnum.valueOf("DIDI");
		System.out.println(providerIdEnum.toString());
	}

	@Getter
	public enum ProviderIdEnum {

		DIDI(1, "滴滴"),
		HXZ(2, "花小猪");

		private Integer code;

		private String desc;

		ProviderIdEnum(Integer code, String desc) {
			this.code = code;
			this.desc = desc;
		}

	}
}
