package com.zxk175.ssm.filter.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防止SQL注入和XSS攻击Filter
 *
 * @Link http://blog.csdn.net/yuwenruli/article/details/6870753
 * Created by zxk175 on 17/3/19.
 */
public class XSSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
                (HttpServletRequest) request);
        filterChain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {
    }
}
