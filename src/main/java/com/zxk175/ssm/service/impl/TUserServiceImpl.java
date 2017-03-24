package com.zxk175.ssm.service.impl;

import com.zxk175.ssm.dao.TUserMapper;
import com.zxk175.ssm.pojo.TUser;
import com.zxk175.ssm.pojo.TUserCriteria;
import com.zxk175.ssm.service.TUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper userDao;

    @Override
    public int insert(TUser user) {
        return userDao.insertSelective(user);
    }

    @Override
    public int delete(Long id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(TUser user, Long id) {
        user.setId(id);
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public TUser selectByPrimaryKey(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TUser> selectByExample(TUserCriteria criteria) {
        return userDao.selectByExample(criteria);
    }
}
