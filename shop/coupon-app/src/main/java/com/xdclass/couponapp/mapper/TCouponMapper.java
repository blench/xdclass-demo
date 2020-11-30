package com.xdclass.couponapp.mapper;

import com.xdclass.couponapp.model.TCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCoupon record);

    int insertSelective(TCoupon record);

    TCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCoupon record);

    int updateByPrimaryKey(TCoupon record);

    List<TCoupon> selectByCode(String code);

    List<TCoupon> selectTCouponList(Integer o);

    List<TCoupon> selectTCouponListByIds(List<Integer> ids);
}