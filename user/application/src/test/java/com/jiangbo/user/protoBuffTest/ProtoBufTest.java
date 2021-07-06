package com.jiangbo.user.protoBuffTest;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * ProtoBufTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/11
 */
public class ProtoBufTest {
	public static void main(String[] args) {

		System.out.println("===== 构建一个returnVO模型开始 =====");
		ReturnVOProto.ReturnVO.Builder builder = ReturnVOProto.ReturnVO.newBuilder();
		builder.setCode("200");
		builder.setData("OK");
		builder.setMessage("GO");


		ReturnVOProto.ReturnVO returnVO = builder.build();
		System.out.println(returnVO.toString());
		System.out.println("===== 构建returnVO模型结束 =====");

		System.out.println("===== returnVO Byte 开始=====");
		for(byte b : returnVO.toByteArray()){
			System.out.print(b);
		}
		System.out.println("\n" + "returnVO" + returnVO.toByteString().size());
		System.out.println("===== returnVO Byte 结束 =====");

		System.out.println("===== returnVO 反序列化生成对象开始 =====");
		ReturnVOProto.ReturnVO returnVO1 = null;
		try {
			returnVO1 =ReturnVOProto.ReturnVO.parseFrom(returnVO.toByteArray());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		System.out.print(returnVO1.toString());
		System.out.println("===== returnVO 反序列化生成对象结束 =====");
	}
}
