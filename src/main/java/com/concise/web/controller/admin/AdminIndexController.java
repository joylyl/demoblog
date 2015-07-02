package com.concise.web.controller.admin;

import com.concise.entity.Article;
import com.concise.entity.User;
import com.concise.service.*;
import com.concise.web.util.UserInfoMap;
import com.concise.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/6.
 */
@Controller
@RequestMapping("admin")
public class AdminIndexController {

    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private ISystemService iSystemService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private WebUtil webUtil;

    /**
     * 后台首页
     * @param model
     * @return
     */
    @RequestMapping("index.html")
    public String index(Model model){
        setAdminIndex(model);
        return "admin/index";
    }

    /**
     * 设置后台信息
     * @param model
     */
    private void setAdminIndex(Model model){
        List<Article> articles = iArticleService.getArticles(0,10 ,false);
        List<Article> maxArticles = iArticleService.getTop10MaxByView();
        List<Article> newArticles = iArticleService.getTop10OrderByDate(true , 10);

        model.addAttribute("orderby" , newArticles);
        model.addAttribute("max",maxArticles);
        model.addAttribute("articles",articles);
    }

    /**
     * 后台首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String indexRoot(Model model){
        setAdminIndex(model);
        return "admin/index";
    }

    @RequestMapping(value="updateCache.do" , method = RequestMethod.GET, produces="text/plain;charset=utf-8")
    public String updateCache(){
        webUtil.index();
        return "redirect:/admin/index.html";
    }

    @RequestMapping(value="system.html")
    public String systemInfo(){
        return "admin/system";
    }

    @RequestMapping(value="system.do" , method = RequestMethod.POST, produces="text/plain;charset=utf-8")
    public String execUpdateSystem(com.concise.entity.System system){
        iSystemService.update(system);
        return "redirect:/admin/index.html";
    }

    @RequestMapping(value="login.html" , method = RequestMethod.GET)
    public String login(){
        return "admin/login";
    }

    @RequestMapping(value="login.do" , method = RequestMethod.POST)
    public String login(String username , String password , HttpServletResponse response, Model model){
        User user = iUserService.getUserByName(username);
        if(null == user){
            model.addAttribute("msg","登录失败 , 用户名不存在");
            return "admin/login";
        }else{
            if(user.getPassword().equals(password)){
                String accessToken = webUtil.getId();
                UserInfoMap.USER_MAP.put(accessToken , user);
                Cookie cookie = new Cookie("accessToken" , accessToken);
                response.addCookie(cookie);
            }else{
                model.addAttribute("msg","登录失败 , 用户名或密码错误");
                return "admin/login";
            }
        }
        return "redirect:/admin/index.html";
    }

    @RequestMapping(value="logout.do" , method = RequestMethod.GET)
    public String logout( HttpServletResponse response){
        Cookie cookie = new Cookie("accessToken" , "");
        response.addCookie(cookie);
        UserInfoMap.USER_MAP.clear();
        return "redirect:/index.html";
    }
}
