package com.zxk175.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zxk175 on 2017/2/21.
 */
public class BaseFilter implements Filter {
    public static final String CTX = "ctx";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //若存在会话则返回该会话，否则新建一个会话。
        //request.getSession(true)
        //若存在会话则返回该会话，否则返回null
        //request.getSession(false)
        //默认为true
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object attribute = session.getAttribute(CTX);
        if (null == attribute) {
            String path = req.getContextPath();
            // 每个页面，都设置一下基础路径
            session.setAttribute(CTX, path);
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
