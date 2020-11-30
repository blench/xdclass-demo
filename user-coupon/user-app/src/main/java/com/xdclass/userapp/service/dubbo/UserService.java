package com.xdclass.userapp.service.dubbo;



import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.xdclass.userapp.mapper.TUserMapper;
import com.xdclass.userapp.model.TUser;
import com.xdclass.userserviceapi.service.IUserService;
import com.xdclass.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author William
 * @version 1.0
 * @description: TODO
 * @date 2020/11/28 19:41
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Resource
    private TUserMapper tUserMapper;

    LoadingCache<Integer, UserVO> userVOLoadingCache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES).refreshAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, UserVO>() {
                @Override
                public UserVO load(Integer id) throws Exception {
                    return loadUserById(id);
                }
            });

    @Override
    public UserVO getUserById(Integer id) {
       UserVO userVO = new UserVO();
        try {
            userVO = userVOLoadingCache.get(1);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return userVO;
    }

    private UserVO loadUserById(Integer id) {
        TUser user = tUserMapper.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
