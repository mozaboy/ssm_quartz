package com.zxk175.ssm.ws.impl;

import com.zxk175.ssm.pojo.TUser;
import com.zxk175.ssm.pojo.TUserCriteria;
import com.zxk175.ssm.service.TUserService;
import com.zxk175.ssm.ws.UserWebService;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by zxk175 on 2017/3/24.
 */
@WebService(serviceName = "userService", endpointInterface = "com.zxk175.ssm.ws.UserWebService")
public class UserWebServiceImpl implements UserWebService {

    @Resource
    private TUserService tUserService;

    /**
     * 根据Id获取用户
     *
     * @param uid
     * @return
     */
    @Override
    public TUser getUserById(String uid) {
        TUser user = tUserService.selectByPrimaryKey(Long.valueOf(uid));
        return user;
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public List<TUser> getUsers() {
        TUserCriteria example = new TUserCriteria();
        TUserCriteria.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo((short) 1);
        List<TUser> users = tUserService.selectByExample(example);
        return users;
    }
}
