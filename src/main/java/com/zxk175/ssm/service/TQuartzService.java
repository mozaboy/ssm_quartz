package com.zxk175.ssm.service;

import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzExample;

import java.util.List;

/**
 * Created by zxk175 on 2017/3/1.
 */
public interface TQuartzService {
    List<TQuartz> getQuartzList(TQuartzExample example);
}
