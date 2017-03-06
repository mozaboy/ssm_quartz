package com.zxk175.ssm.util.quartz;

import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzExample;
import com.zxk175.ssm.service.TQuartzService;

import javax.annotation.Resource;
import java.util.List;

public class QuartzExecute {
    @Resource
    private TQuartzService quartzService;

    /**
     * spring加载完就执行该方法：init-method="autoLoadTask"
     */
    public void autoLoadTask() {
        // 获取到所有需要启动的quartz集合
        System.out.println("【系统启动】所有定时任务开启...");
        TQuartzExample example = new TQuartzExample();
        TQuartzExample.Criteria criteria = example.createCriteria();
        // 是否禁用:0禁用;1启用
        criteria.andEnableStatusEqualTo("1");
        // 任务状态:0关闭;1运行中;2暂停
        //criteria.andTriggerStatusEqualTo(null);
        List<TQuartz> quartzList = quartzService.getQuartzList(example);

        if (null == quartzList) {
            return;
        }

        int size = quartzList.size();
        for (int i = 0; i < size; i++) {
            System.out.println("定时任务个数：" + size);
            try {
                TQuartz quartz = quartzList.get(i);
                QuartzUtil.addJob(quartz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
