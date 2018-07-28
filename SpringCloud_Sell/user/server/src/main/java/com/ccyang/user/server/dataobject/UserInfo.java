package com.ccyang.user.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ccyang
 * @date 2018/7/10 19:36
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;
    /** 微信openId , 唯一标识 */
    private String openid;
    /** 1: 买家  2：卖家 */
    private Integer role;

}
