//package com.jiangbo.user;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//import java.time.Instant;
//import java.util.Objects;
//
///**
// * CacheTest
// *
// * @author chengjiangbo@shandiantech.com
// * @version 1.0.0
// * @date 2020/09/18
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CacheTest {
//
//  @Resource(name = "fastJson")
//  private RedisTemplate<Object, Object> fastJsonRedisTemplate;
//
//  @Resource(name = "jackson")
//  private RedisTemplate<Object, Object> jacksonRedisTemplate;
//
//  @Resource(name = "protobuf")
//  private RestTemplate restTemplate;
//
//  @Test
//  public void cacheVO(){
//    EstimatePriceCacheVO vo = new EstimatePriceCacheVO();
//
//    vo.setDispatchAppId("1007");
//    vo.setDispatchBrandNo("198818554668126211");
//    vo.setBrandNo("198818554668126212");
//    vo.setInquiryOrderNo("226671449434329089");
//    vo.setOrderNo("226671449434329089");
//    vo.setProviderNo("174986925763985408");
//    vo.setProviderName("滴滴");
//    vo.setAppId("1007");
//    vo.setStartLon(120.12096);
//    vo.setStartLat(30.279136);
//    vo.setEndLon(119.961284);
//    vo.setEndLat(30.390308);
//    vo.setCityCode("0571");
//    vo.setCityName("杭州市");
//    vo.setBusinessTypeCode("1");
//    vo.setBusinessTypeShow("快车");
//    vo.setCapacityTypeCode("1");
//    vo.setCapacityTypeShow("经济");
//    vo.setPlanUseTime(2603);
//    vo.setPlanMileage(23852);
//    vo.setCalculateTime(2280);
//    vo.setCalculateMileage(21900);
//    vo.setPlanTotalAmount(8472);
//    vo.setPlanStartFare(1100);
//    vo.setPlanLongDistance(18900);
//    vo.setPlanLongDistanceFare(567);
//    vo.setPlanPeakTimeFare(0);
//    vo.setPlanOtherPeakTimeFare(0);
//    vo.setPlanMileageFare(5475);
//    vo.setPlanTimeFare(1330);
//    vo.setPlanOtherFare(0);
//    vo.setFareRuleId(161L);
//    vo.setStatus(0);
//    vo.setStatusShow("询价");
//    vo.setCreatedAt(Instant.now().toEpochMilli());
//    vo.setChannel("didi");
//
//    String fastJsonKey = vo.getOrderNo() + "_fast";
//    String jackJsonKey = vo.getOrderNo() + "_jack";
//
//    fastJsonRedisTemplate.opsForValue().set(fastJsonKey, vo);
//    jacksonRedisTemplate.opsForValue().set(jackJsonKey, vo);
//
//    Object fastJsonObject = fastJsonRedisTemplate.opsForValue().get(fastJsonKey);
//    Object jackJsonObject = jacksonRedisTemplate.opsForValue().get(jackJsonKey);
//
//    System.out.println(fastJsonObject.toString().length());
//    System.out.println(jackJsonObject.toString().length());
//
//    jacksonRedisTemplate.opsForValue().set("abc", Boolean.TRUE);
//    System.out.println(Objects.nonNull(jacksonRedisTemplate.opsForValue().get("abc")));
//  }
//
//  @Setter
//  @Getter
//  @ToString
//  static class EstimatePriceCacheVO {
//    /**
//     * 调度appId
//     */
//    private String dispatchAppId;
//
//    /**
//     * 调度品牌
//     */
//    private String dispatchBrandNo;
//
//    /**
//     * 内部品牌方编号（主要用于调度）
//     */
//    private String brandNo;
//
//    private String inquiryOrderNo;
//
//    private String orderNo;
//
//    /**
//     * pbd渠道内部编号
//     */
//    @Deprecated
//    private String providerNo;
//
//    /**
//     * pbd渠道内部名称
//     */
//    @Deprecated
//    private String providerName;
//
//    /**
//     * 内部appId
//     */
//    private String appId;
//
//    private String providerOrderNo;
//
//    private String startAddr;
//
//    private Double startLon;
//
//    private Double startLat;
//
//    private String endAddr;
//
//    private Double endLon;
//
//    private Double endLat;
//
//    private String cityCode;
//
//    private String cityName;
//
//    private String businessTypeCode;
//
//    private String businessTypeShow;
//
//    private String capacityTypeCode;
//
//    private String capacityTypeShow;
//
//    private Integer planUseTime;
//
//    private Integer planMileage;
//    /**
//     * 行驶时长（不含起步时长）
//     */
//    private Integer calculateTime;
//    /**
//     * 行驶里程（不含起步里程）
//     */
//    private Integer calculateMileage;
//
//    private Integer planTotalAmount;
//
//    private Integer planStartFare;
//
//    private Integer planLongDistance;
//
//    private Integer planLongDistanceFare;
//
//    private Integer planPeakTimeFare;
//
//    private Integer planOtherPeakTimeFare;
//
//    private Integer planMileageFare;
//
//    private Integer planTimeFare;
//
//    private Integer planOtherFare;
//
//    private Long fareRuleId;
//
//    private Integer status;
//
//    private String statusShow;
//
//    private Long createdAt;
//
//    private String orderType;
//
//    private String orderTypeShow;
//
//    private String channel;
//  }
//}
