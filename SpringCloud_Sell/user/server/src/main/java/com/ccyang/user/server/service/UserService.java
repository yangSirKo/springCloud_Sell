package com.ccyang.user.server.service;

import com.ccyang.user.server.dataobject.UserInfo;

/**
 * @author ccyang
 * @date 2018/7/10 19:43
 */
public interface UserService {

    /**
     * 根据 openid 查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
