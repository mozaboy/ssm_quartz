package com.zxk175.ssm.controller;

import com.zxk175.ssm.dto.ExceptionVo;
import com.zxk175.ssm.exception.BusinessException;
import com.zxk175.ssm.exception.ParameterException;
import com.zxk175.ssm.util.json.JacksonUtil;
import com.zxk175.ssm.util.web.RequestUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zxk175 on 2017/2/20.
 */

// @ControllerAdvice把异常处理器应用到所有控制器
// 而不是@Controller注解的单个控制器
@ControllerAdvice
public class BaseController {
    public static final String SPANSTART = "<span style='padding: 0 0 0 20px;color:#f00'>";
    public static final String SPANEND = "</span>";

    /**
     * 跳转默认页面
     *
     * @return
     */
    @ApiIgnore
    @RequestMapping("/")
    public String toIndex() {
        return "redirect:/index.jsp";
    }

    /**
     * 全局异常处理
     *
     * @param request
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {Exception.class, Throwable.class})
    public Object exceptionHandler(HttpServletRequest request, Exception ex) throws IOException {
        boolean isAjax = RequestUtil.isAjaxRequest(request);
        StackTraceElement[] stackTrace = ex.getStackTrace();
        StringBuffer sb = new StringBuffer();
        for (StackTraceElement ste : stackTrace) {
            if (isAjax) {
                sb.append(SPANSTART + "at ").append(ste).append(SPANEND + "<br/>");
            } else {
                sb.append("at ").append(ste).append("<br/>");
            }
        }
        String exType = SPANSTART + ex + SPANEND + "<br/>";

        ModelAndView mv = null;
        if (isAjax) {
            request.setAttribute("page_title", "Ajax请求异常页");
            return JacksonUtil.objectToJsonStr(new ExceptionVo(500, exType, sb.toString()));
        } else {
            mv = new ModelAndView();
            mv.addObject("exType", ex);
            mv.addObject("exMsg", sb.toString());
            // 根据不同错误转向不同页面
            if (ex instanceof BusinessException) {
                request.setAttribute("page_title", "业务异常页");
                mv.setViewName("error/error_business");
                return mv;
            } else if (ex instanceof ParameterException) {
                request.setAttribute("page_title", "参数异常页");
                mv.setViewName("error/error_parameter");
                return mv;
            } else {
                request.setAttribute("page_title", "通用异常页");
                mv.setViewName("error/error");
                return mv;
            }
        }
    }
}
