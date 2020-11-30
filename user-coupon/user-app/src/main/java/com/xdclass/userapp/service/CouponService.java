package com.xdclass.userapp.service;

import com.xdclass.userapp.mapper.TCouponMapper;
import com.xdclass.userapp.model.TCoupon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CouponService {

    @Resource
    private TCouponMapper tCouponMapper;

    public void print() {
        System.out.println("CouponService is ");
    }

    public TCoupon getById(Integer id) {
        return tCouponMapper.selectByPrimaryKey(id);
    }

    public List<TCoupon> getByCode(String code) {
        return tCouponMapper.selectByCode(code);
    }
}
