package com.xdclass.couponapp.controller;

import com.xdclass.couponapp.mapper.TCouponMapper;
import com.xdclass.couponapp.model.TCoupon;
import com.xdclass.couponapp.service.CouponService;
import com.xdclass.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private CouponService couponService;

    @RequestMapping("/")
    public String test() {
        return "test";
    }

    @RequestMapping("/test")
    public String testQuery() {
        List<TCoupon> tCoupons = couponService.getByCode("3f10ded9-ea5c-409c-b2fc-e7178f54fce9");
        System.out.println(tCoupons);
        return "test";
    }

    @RequestMapping("/user")
    public UserVO testUserQuery(Integer id) {
        if(id == null || id == 0) {
            return new UserVO();
        }
        UserVO userVO = couponService.getUserById(id);
        return userVO;
    }
}
