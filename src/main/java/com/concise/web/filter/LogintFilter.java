package com.concise.web.filter;

import com.concise.entity.User;
import com.concise.web.util.UserInfoMap;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 刘印龙 on 2015/7/2.
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
, urlPatterns = { "/admin/*" })
public class LogintFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse hsresponse = (HttpServletResponse) response;
        HttpServletRequest hsrequest = (HttpServletRequest)request;
        Cookie[] cookies = hsrequest.getCookies();
        if(hsrequest.getRequestURI().indexOf("admin/login") != -1){
            chain.doFilter( request ,response );
            return;
        }
        String accessToken = "";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("accessToken")){
                accessToken = cookie.getValue();
            }
        }
        User user = UserInfoMap.USER_MAP.get(accessToken);
        if(null == user){
            hsresponse.sendRedirect("login.html");
            return ;
        }
        chain.doFilter(request , response);
    }

    public void destroy() {

    }
}
