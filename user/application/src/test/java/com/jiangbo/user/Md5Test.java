package com.jiangbo.user;

import java.security.MessageDigest;

/**
 * Md5Test
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/25
 */
public class Md5Test {
		private static String getMd5_16(String string) {
			// TODO Auto-generated method stub
			return encrypt32(string).substring(8, 24);
		}

		public static String encrypt32(String encryptStr) {
			MessageDigest md5;
			try {
				md5 = MessageDigest.getInstance("MD5");
				byte[] md5Bytes = md5.digest(encryptStr.getBytes());
				StringBuffer hexValue = new StringBuffer();
				for (int i = 0; i < md5Bytes.length; i++) {
					int val = ((int) md5Bytes[i]) & 0xff;
					if (val < 16)
						hexValue.append("0");
					hexValue.append(Integer.toHexString(val));
				}
				encryptStr = hexValue.toString();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return encryptStr;
		}

	public static void main(String[] args) {
			//52d04dc20036dbd8
		System.out.println(getMd5_16("1234"));

		StringBuilder stringBuilder = new StringBuilder();
		byte[] bytes ="skio".getBytes();
		for (byte aByte : bytes) {
			stringBuilder.append(aByte);
		}
		stringBuilder.append("0000");
		System.out.println(stringBuilder.toString());

	}

}
