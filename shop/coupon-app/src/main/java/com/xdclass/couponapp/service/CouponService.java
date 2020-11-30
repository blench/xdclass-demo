package com.xdclass.couponapp.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.xdclass.couponapp.mapper.TCouponMapper;
import com.xdclass.couponapp.model.TCoupon;
import com.xdclass.userserviceapi.service.IUserService;
import com.xdclass.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Reference
    private IUserService userService;

    LoadingCache<Integer, TCoupon> couponCache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES).refreshAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, TCoupon>() {
                @Override
                public TCoupon load(Integer i) throws Exception {
                    return loadIdTCoupon(i);
                }
            });

    private List<TCoupon> loadCoupon(Integer i) {

        return null;
    }

    private TCoupon loadIdTCoupon(Integer id) {
        return tCouponMapper.selectByPrimaryKey(id);
    }


    public List<TCoupon> getCouponListByIds(String ids) {
        String[] idsStr = ids.split(",");
        List<Integer> loadFromDB = Lists.newArrayList();
        List<String> idList = Lists.newArrayList(idsStr);
        List<TCoupon> tCouponList = Lists.newArrayList();
        for(String id : idList) {
            TCoupon tCoupon = couponCache.getIfPresent(id);
            if(tCoupon == null) {
                loadFromDB.add(Integer.valueOf(id));
            } else {
                tCouponList.add(tCoupon);
            }
        }

        //对于不在缓存中的数据从数据库中批量查询
        List<TCoupon> tCouponByIds = getTCouponByIds(loadFromDB);
        Map<Integer, TCoupon> map = tCouponByIds.stream().collect(Collectors.toMap(TCoupon::getId, TCoupon -> TCoupon));
        //讲返回结果重写到缓存中
        couponCache.putAll(map);
        tCouponList.addAll(tCouponByIds);
        return tCouponList;
    }


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

    public UserVO getUserById(Integer id) {
        return userService.getUserById(id);
    }

//    public List<TCoupon> getCouponList() {
//        List<TCoupon> list = Lists.newArrayList();
//        try {
//           list =  couponCache.get(1);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public List<TCoupon> getTCouponByIds(List<Integer> ids) {
        return tCouponMapper.selectTCouponListByIds(ids);
    }
    //影响性能的因素
    //1、是否存在远程调用 HTTP、RPC Metrics 调用
    //2、大量内存操作 list.contain() ==> set.contain()
    //根据不同场景去进行分析，读多写少，读少写多，种种情况
}
