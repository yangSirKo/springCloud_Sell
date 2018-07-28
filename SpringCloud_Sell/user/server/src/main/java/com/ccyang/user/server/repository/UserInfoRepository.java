package com.ccyang.user.server.repository;

import com.ccyang.user.server.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ccyang
 * @date 2018/7/10 19:40
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);

}
