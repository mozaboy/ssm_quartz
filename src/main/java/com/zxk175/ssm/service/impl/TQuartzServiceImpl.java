package com.zxk175.ssm.service.impl;

import com.zxk175.ssm.dao.TQuartzMapper;
import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzCriteria;
import com.zxk175.ssm.service.TQuartzService;
import com.zxk175.ssm.util.quartz.QuartzUtil;
import org.quartz.SchedulerException;
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
    public List<TQuartz> getQuartzList(TQuartzCriteria criteria) {
        return quartzMapper.selectByExample(criteria);
    }

    @Override
    public int pauseJob(TQuartz quartz) throws SchedulerException {
        QuartzUtil.pauseJob(quartz);
        return quartzMapper.updateByPrimaryKeySelective(quartz);
    }

    @Override
    public int resumeJob(TQuartz quartz) throws SchedulerException {
        QuartzUtil.resumeJob(quartz);
        return quartzMapper.updateByPrimaryKeySelective(quartz);
    }
}
