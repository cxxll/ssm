package cn.ssm.interceptor;

import cn.ssm.model.User;
import cn.ssm.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Created by Administrator on 2016/7/27.
 */
public class UserSessionInterceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(UserSessionInterceptor.class);
    public static final String LAST_PAGE = "com.alibaba.lastPage";


    /**
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            RequestUtil.saveRequest(request);
        }
        log.info("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        System.out.print("ss");
        log.info("requestUri:"+requestUri);
        log.info("contextPath:"+contextPath);
        log.info("url:"+url);

            User loginUser =  (User)request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            log.info("Interceptor：跳转到login页面！");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            System.out.print("ccc");
            return false;
        }else
            return true;
    }



    /**
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

