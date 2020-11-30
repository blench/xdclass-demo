package com.xdclass.couponapp.mapper;

import com.xdclass.couponapp.model.TUserCoupon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUserCoupon record);

    int insertSelective(TUserCoupon record);

    TUserCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserCoupon record);

    int updateByPrimaryKey(TUserCoupon record);
}