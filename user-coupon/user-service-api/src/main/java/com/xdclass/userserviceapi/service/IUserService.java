package com.xdclass.userserviceapi.service;

import com.xdclass.userserviceapi.vo.UserVO;

/**
 * @author William
 * @version 1.0
 * @description: TODO
 * @date 2020/11/28 20:21
 */

public interface IUserService {

    UserVO getUserById(Integer id);
}
