package com.zxk175.ssm.util.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zxk175 on 2017/2/21.
 */
public class RequestUtil {
    public static final String X_REQUESTED_WIDTH = "X-Requested-With";
    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    private RequestUtil() {
    }

    /**
     * 判断是否ajax请求.
     * 可以看到ajax 请求多了个 x-requested-with ，可以利用它
     * request.getHeader("x-requested-with")
     * 为 null，则为传统同步请求，为 XMLHttpRequest，则为ajax 异步请求
     *
     * @param request HttpServletRequest
     * @return 是否ajax请求.
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String xr = request.getHeader(X_REQUESTED_WIDTH);
        return (xr != null && XML_HTTP_REQUEST.equalsIgnoreCase(xr));
    }

    /**
     * 获取Cookie Value
     *
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
