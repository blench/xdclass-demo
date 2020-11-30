package com.xdclass.userapp.controller;

import com.xdclass.userapp.model.TCoupon;
import com.xdclass.userserviceapi.vo.UserVO;
import com.xdclass.userapp.service.CouponService;
import com.xdclass.userapp.service.dubbo.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private CouponService couponService;

    @Resource
    private UserService userService;

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
    public UserVO getQuery(Integer id) {
        if(id == null || id == 0) {
            return new UserVO();
        }
        return userService.getUserById(id);
    }
}
