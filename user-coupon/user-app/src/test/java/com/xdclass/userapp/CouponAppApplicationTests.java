package com.xdclass.userapp;

import com.xdclass.userapp.mapper.TCouponMapper;
import com.xdclass.userapp.mapper.TUserMapper;
import com.xdclass.userapp.model.TCoupon;
import com.xdclass.userapp.model.TUser;
import com.xdclass.userapp.service.CouponService;
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
public class CouponAppApplicationTests {

    @Resource
    private CouponService couponService;

    @Resource
    private TCouponMapper tCouponMapper;

    @Resource
    private TUserMapper tUserMapper;

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

    @Test
    public void testInsert() {
        TUser user = new TUser();
        user.setPhone("123453544");
        user.setAccount("1235435");
        user.setPassword("123456");
        user.setAddress("北京");
        user.setUsername("小帅哥");
        user.setTelPhone("1234235465");
        user.setZipCode("435500");
        tUserMapper.insert(user);
    }
}
