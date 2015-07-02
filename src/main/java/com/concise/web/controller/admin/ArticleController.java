package com.concise.web.controller.admin;

import com.concise.entity.Article;
import com.concise.entity.Category;
import com.concise.entity.Tag;
import com.concise.service.IArticleService;
import com.concise.service.ICategoryService;
import com.concise.service.ITagService;
import com.concise.web.util.WebUtil;
import org.markdown4j.Markdown4jProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 刘印龙 on 2015/6/8.
 */
@Controller
@RequestMapping("admin/article")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private WebUtil webUtil;


    /**
     * 跳转到修改文章的页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("{id}/update.html")
    public String updateArticle(@PathVariable("id") Integer id , Model model){
        Article article = iArticleService.getArticleById(id);
        List<Tag> tags = iTagService.getTags();
        model.addAttribute("tags",tags);
        System.out.print(article.getId());
        model.addAttribute("article",article);
        return "admin/article/update";
    }

    /**
     * 跳转到添加文章的页面
     * @param model
     * @return
     */
    @RequestMapping("add.html")
    public String addArticle(Model model){
        List<Category> categories = iCategoryService.getByKeyword("");
        List<Tag> tags = iTagService.getTags();
        model.addAttribute(categories);
        model.addAttribute("tags", tags);
        return "admin/article/update";
    }

    /**
     * 添加文章操作
     * @param article
     * @param isrecover
     * @return
     */
    @RequestMapping(value = "add.do" , method = RequestMethod.POST)
    public String execAddArticle(@ModelAttribute("article") Article article ,Integer[] isrecover ){
        article.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        article.setContentSource(article.getContent());
        try {
            article.setContent(new Markdown4jProcessor().process(article.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置是否进入回收站
        if(isrecover == null)
            isrecover = new Integer[]{0};

        article.setIsrecover(isrecover[0]);

        iArticleService.add(article);
        return "redirect:/admin/index.html";
    }

    /**
     * 执行修改文章操作
     * @param article
     * @param isrecover
     * @return
     */
    @RequestMapping(value = "execUpdate.do" , method = RequestMethod.POST)
    public String execUpdate(@ModelAttribute("article") Article article ,Integer[] isrecover ){
        article.setContentSource(article.getContent());
        try {
            article.setContent(new Markdown4jProcessor().process(article.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置是否进入回收站
        if(isrecover == null)
            isrecover = new Integer[]{0};

        article.setIsrecover(isrecover[0]);

        iArticleService.update(article);
        return "redirect:/admin/index.html";
    }

    /**
     * 文章进入回收站操作
     * @param id
     * @return
     */
    @RequestMapping(value = "trash.do")
    public String trash(Integer id){
        iArticleService.trashArticle(id);
        return "redirect:/admin/index.html";
    }

    /**
     * 文章从回收站恢复
     * @param id
     * @return
     */
    @RequestMapping(value = "notrash.do")
    public String notrash(Integer id){
        Article article = iArticleService.getArticleById(id);
        article.setIsrecover(0);
        iArticleService.update(article);
        return "redirect:/admin/index.html";
    }

}
