package com.concise.web.interceptor;

import com.concise.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 刘印龙 on 2015/5/14.
 */
@Component
public class SidebarInterceptor implements WebRequestInterceptor {


    @Autowired
    private WebUtil webUtil;

    public void preHandle(WebRequest webRequest) throws Exception {

    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        webUtil.index();
    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
