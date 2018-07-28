package com.ccyang.user.server.service.impl;

import com.ccyang.user.server.dataobject.UserInfo;
import com.ccyang.user.server.repository.UserInfoRepository;
import com.ccyang.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ccyang
 * @date 2018/7/10 19:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
