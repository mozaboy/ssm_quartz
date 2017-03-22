package com.zxk175.ssm.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TChina {
    private Integer cityId;

    private String cityName;

    private Integer parentId;

    public TChina(Integer cityId, String cityName, Integer parentId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.parentId = parentId;
    }

    public TChina() {
        super();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", parentId=").append(parentId);
        sb.append("]");
        return sb.toString();
    }
}