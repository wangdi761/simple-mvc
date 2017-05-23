package com.wangdi.common.interceptor;

import com.wangdi.user.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录拦截器
 * Created by D on 2017/5/22.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> excludeUrls;

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        String servletPath = httpServletRequest.getServletPath();

        if (excludeUrls.contains(servletPath)) {
            return true;
        }

        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
            httpServletRequest.setAttribute("message", "请先登录再访问网站");
            httpServletRequest.getRequestDispatcher("loginForm")
                    .forward(httpServletRequest, httpServletResponse);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}
