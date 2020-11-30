package com.xdclass.couponapp;

import com.xdclass.couponapp.mapper.TCouponMapper;
import com.xdclass.couponapp.model.TCoupon;
import com.xdclass.couponapp.service.CouponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.xdclass.couponapp.mapper")
public class CouponAppApplicationTests {

    @Resource
    private CouponService couponService;

    @Resource
    private TCouponMapper tCouponMapper;

    @Test
    public void contextLoads() {
        System.out.println("hello world");
        couponService.print();
    }

    @Test
    public void insert() {
        for(int i = 0; i < 100000; i++) {
            TCoupon tCoupon = new TCoupon();
            tCoupon.setArchieveAmount(500);
            tCoupon.setReduceAmount(20);
            tCoupon.setCode(UUID.randomUUID().toString());
            tCoupon.setPicUrl("1.png");
            tCoupon.setStatus(0);
            tCoupon.setStock(500);
            tCoupon.setTitle("满 500 减 20");
            tCoupon.setCreateTime(new Date());
            tCouponMapper.insert(tCoupon);
        }

    }


    @Test
    public void select() {
        TCoupon tCoupon = tCouponMapper.selectByPrimaryKey(1);
        System.out.println(tCoupon.toString());
    }

    @Test
    public void update() {
        TCoupon tCoupon = tCouponMapper.selectByPrimaryKey(1);
        tCoupon.setTitle("ceshi");
        tCoupon.setStock(300);
        tCoupon.setPicUrl("2.jpg");
        tCoupon.setStatus(1);
        tCoupon.setReduceAmount(10);
        tCoupon.setArchieveAmount(300);
        tCoupon.setCreateTime(new Date());
        int i = tCouponMapper.updateByPrimaryKey(tCoupon);
        System.out.println("i 的值为： " + i);
    }

    @Test
    public void delete() {
        int i = tCouponMapper.deleteByPrimaryKey(1);
        System.out.println("i 的值为： " + i);
    }
}
