package com.zxk175.ssm.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * TODO(获取到项目中定义的bean)
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     * TODO(实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.)
     *
     * @param applicationContext
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * TODO(取得存储在静态变量中的ApplicationContext.)
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * TODO(从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.)
     *
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    /**
     * TODO(从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.)
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return (T) applicationContext.getBeansOfType(clazz);
    }
}
