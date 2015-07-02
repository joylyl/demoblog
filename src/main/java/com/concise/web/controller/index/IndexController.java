package com.concise.web.controller.index;

import com.concise.entity.*;
import com.concise.service.IArticleService;
import com.concise.service.ICategoryService;
import com.concise.service.ITagService;
import com.concise.web.util.WebUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.System;
import java.util.List;

/**
 * 首页控制器
 * Created by 刘印龙 on 2015/5/5.
 */
@Controller
public class IndexController {

    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private WebUtil webUtil;

    private static Integer initCount = 0;

    @RequestMapping(value="index.html" , method = RequestMethod.GET)
    public String index(Model model , @RequestHeader("User-Agent") String userAgent){
        if(initCount == 0)
            webUtil.index();
        initCount++;
        List<Article> articles = null;
        if(userAgent.indexOf("Android") > 0 || userAgent.indexOf("iPhone") > 0){
            articles = iArticleService.getArticles(0,1,true);
            model.addAttribute("articles", articles);
            return "wap/index";
        }else{
            articles = iArticleService.getArticles(0,10,true);
        }
        model.addAttribute("articles", articles);

        return "index";
    }


    @ResponseBody
    @RequestMapping(value="ajaxGetArticles.do" , method = RequestMethod.POST, produces="text/plain;charset=utf-8")
    public String ajaxGetArticles(Integer pageNo , Integer pageSize){
        List<Article> articles = iArticleService.getArticles(pageNo,pageSize,true);
        return new Gson().toJson(articles);
    }

    /**
     * 直接访问域名
     * @return
     */
    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String indexRoot(Model model, @RequestHeader("User-Agent") String userAgent){
        if(initCount == 0)
            webUtil.index();
        initCount++;

        List<Article> articles = null;
        if(userAgent.indexOf("Android") > 0 || userAgent.indexOf("iPhone") > 0){
            articles = iArticleService.getArticles(0,20,true);
            model.addAttribute("articles", articles);
            return "wap/index";
        }else{
            articles = iArticleService.getArticles(0,10,true);
        }
        model.addAttribute("articles", articles);

        return "index";
    }

    @RequestMapping("category/{name}.html")
    public String category(@PathVariable("name") String name , Model model){
        Category category  = iCategoryService.getName(name);
        List<Article> articles = null;
        if(null != category){
            articles = iArticleService.getArticlesByCategoryId(category.getId());
            name = category.getTitle();
        }

        model.addAttribute("articles", articles);
        model.addAttribute("categoryName", name);
        return "index";
    }

    @RequestMapping("search.do")
    public String getArticlesBykeyword(String keyword , Model model){
        List<Article> articles  = iArticleService.getArticlesBykeyword(keyword);
        model.addAttribute("articles", articles);
        model.addAttribute("searchKeyWord", keyword);
        return "index";
    }

    /**
     * 通过static url 查看文章内容
     */
    @RequestMapping("info/{staticurl}.html")
    public String getInfoById(@PathVariable("staticurl") String staticurl , Model model , @RequestHeader(value = "Referer" , required = false ) String referer , @RequestHeader("User-Agent") String userAgent){

        Article article = iArticleService.getArticleByStaticURL(staticurl);

        //添加阅读次数
        article.setView(article.getView()+1);

        iArticleService.update(article);

        model.addAttribute("article", article);
        if(userAgent.indexOf("Android") > 0 || userAgent.indexOf("iPhone") > 0){
            return "wap/article";
        }
        return "article";
    }

    @RequestMapping("tag/{alias}.html")
    public String getBytag(@PathVariable("alias") String alias , Model model){
        List<Article> articles = iArticleService.getByTag(alias);
        Tag tag = iTagService.getTagsByKeyword("alias", alias).get(0);
        model.addAttribute("articles", articles);
        model.addAttribute("tagName", tag.getName());
        return "index";
    }

}
