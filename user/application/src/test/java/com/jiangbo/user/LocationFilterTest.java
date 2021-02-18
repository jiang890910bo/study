package com.jiangbo.user;

import org.apache.lucene.util.SloppyMath;

/**
 * LocationFilterTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/27
 */
public class LocationFilterTest {
	public static void main(String[] args) {
		double startLon = 120.12096;
		double startLat = 30.279136;
		double endLat = 30.279397;
		double endLon = 120.120211;
		double meters = SloppyMath.haversinMeters(startLat, startLon, endLat, endLon);
		System.out.println(meters);
	}
}
