package com.zxk175.ssm.task;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zxk175 on 2017/2/22.
 */
public class XmlTask {
    private String date;

    private String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public void show() {
        date = formatDate();
        //System.out.println("Xml：is show run time：" + date);
    }
}
