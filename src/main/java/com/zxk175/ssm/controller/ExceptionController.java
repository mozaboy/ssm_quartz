package com.zxk175.ssm.controller;

import com.zxk175.ssm.exception.BusinessException;
import com.zxk175.ssm.exception.ParameterException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by zxk175 on 2017/2/20.
 */
@ApiIgnore
@Controller
public class ExceptionController extends BaseController {
    /**
     * 测试全局异常处理
     *
     * @param id
     * @throws Exception
     */
    @RequestMapping("/ex")
    public void testException(Integer id) throws Exception {
        switch (id) {
            case 10:
                throw new BusinessException("业务逻辑异常！");
            case 20:
                throw new ParameterException("传递参数异常！");
        }
    }
}
