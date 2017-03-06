package com.zxk175.ssm.service;

import com.zxk175.ssm.pojo.TUser;
import com.zxk175.ssm.pojo.TUserExample;

import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */
public interface TUserService {
    int insert(TUser user);

    int delete(Long id);

    int update(TUser user, Long uid);

    List<TUser> getAllUserByExample(TUserExample example);
}