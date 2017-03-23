package com.zxk175.ssm.dto.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by zxk175 on 2017/3/23.
 */
public class MyObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    /**
     * 不返回空对象及变量
     *
     * @param incl
     * @return
     */
    @Override
    public ObjectMapper setSerializationInclusion(JsonInclude.Include incl) {
        setPropertyInclusion(JsonInclude.Value.construct(incl, JsonInclude.Include.NON_EMPTY));
        return this;
    }
}
