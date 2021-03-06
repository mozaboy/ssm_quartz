package com.zxk175.ssm.dto.table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zxk175 on 2017/3/20.
 */
public class BTPages<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    // 成功与否
    private boolean success;
    // 信息
    private String msg;
    // 状态
    private Integer status;
    // 总条数
    private Integer total;
    // 当前页显示数据
    private List<T> records;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
