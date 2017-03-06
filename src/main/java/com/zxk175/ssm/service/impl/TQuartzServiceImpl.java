package com.zxk175.ssm.service.impl;

import com.zxk175.ssm.dao.TQuartzMapper;
import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzExample;
import com.zxk175.ssm.service.TQuartzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

@Service("quartzService")
public class TQuartzServiceImpl implements TQuartzService {
    @Resource
    private TQuartzMapper quartzMapper;

    @Override
    public List<TQuartz> getQuartzList(TQuartzExample example) {
        return quartzMapper.selectByExample(example);
    }
}
