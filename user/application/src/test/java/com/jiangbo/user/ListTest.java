package com.jiangbo.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ListTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/23
 */
@Slf4j
public class ListTest extends Thread{

	private static Integer corePoolSize = Runtime.getRuntime().availableProcessors();

	private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2* corePoolSize, 2* corePoolSize, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());

	private static int size = 10;

	private static AtomicLong atomicInteger = new AtomicLong(0);

	public static void main(String[] args) {
		while(true){
			ListTest listTest = new ListTest();
			threadPoolExecutor.execute(listTest);
		}
	}

	@Override
	public void run() {
		String jsonValue = "{\"carNo\":\"贵AD01171\",\"cityCode\":\"0851\",\"dataVersion\":\"100\",\"deviceId\":\"6ACA2ADC-DB69-4DF5-8180-51E12240246B\",\"direction\":\"330.3644104003906\",\"driverNo\":\"253554271105859585\",\"driverStatus\":\"2\",\"height\":\"1143.83\",\"isForeground\":\"1\",\"lat\":\"26.566865\",\"locateTime\":\"1608777344000\",\"lon\":\"106.6721\",\"orderNo\":\"262165876014116864\",\"orderStatus\":\"2\",\"page\":\"_0\",\"phoneType\":\"I\",\"provider\":\"0\",\"radius\":\"10\",\"rideTypeCode\":\"1\",\"speed\":\"0.1899999976158142\"}";
		testListMemory(jsonValue);

		System.out.println("第" + atomicInteger.incrementAndGet() + "次循环。");
	}

	private void testListMemory(String jsonValue) {
		List<DriveLocationMessage> messageList = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			DriveLocationMessage message = JSON.parseObject(jsonValue, DriveLocationMessage.class);
			messageList.add(message);
		}

		try {
			Thread.sleep(5000L);
			System.out.println("第一个司机车牌号：+" +messageList.get(0).getCarNo());
			int num = 1/0;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Setter
	@Getter
	static class DriveLocationMessage{

		/**
		 * 数据版本号
		 */
		private String dataVersion;

		/**
		 * 行政区划代码
		 */
		private String cityCode;

		/**
		 * 运力类型编码,快车舒适型Code、专车经济型Code
		 */
		private String rideTypeCode;

		/**
		 * 司机工号
		 */
		private String driverNo;

		/**
		 * 司机状态 0：未听单 1：听单中 2：服务中
		 */
		private String driverStatus;

		/**
		 * 车牌号
		 */
		private String carNo;

		/**
		 * 经度
		 */
		private String lon;

		/**
		 * 纬度
		 */
		private String lat;

		/**
		 * 车头朝向
		 */
		private String direction;

		/**
		 * 速度
		 */
		private String speed;

		/**
		 * 海拔
		 */
		private String height;

		/**
		 * 定位精度
		 */
		private String radius;

		/**
		 * 定位类型,0:GPS,1:基站,2:其他
		 */
		private String provider;

		/**
		 * 上报时间戳,unix时间戳表示,需要精确到毫秒
		 */
		private String locateTime;

		/**
		 * 手机设备id
		 */
		private String deviceId;

		/**
		 * 手机系统标示:  A:安卓,I:iOS
		 */
		private String phoneType;

		/**
		 * 订单编号
		 */
		private String orderNo;

		/**
		 * 订单状态
		 */
		private String orderStatus;

		/**
		 * 前后台（0: 后台, 1: 前台）
		 */
		private String isForeground;

		/**
		 * 页面名称（后台时: b）
		 */
		private String page;

		@Override
		public boolean equals(Object o) {
			if (this == o) {return true;}
			if (o == null || getClass() != o.getClass()) {return false;}
			DriveLocationMessage that = (DriveLocationMessage) o;
			return Objects.equals(driverNo, that.driverNo) &&
				Objects.equals(lon, that.lon) &&
				Objects.equals(lat, that.lat) &&
				Objects.equals(driverStatus, that.driverStatus);
		}

		@Override
		public int hashCode() {
			return Objects.hash(driverNo, lon, lat, driverStatus);
		}
	}
}
