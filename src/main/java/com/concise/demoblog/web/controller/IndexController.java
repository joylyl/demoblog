package com.concise.demoblog.web.controller;

import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;

import com.concise.demoblog.data.entity.Article;
import com.concise.demoblog.data.entity.Category;
import com.concise.demoblog.data.service.ArticleService;
import com.concise.demoblog.data.service.CategoryService;
import com.concise.demoblog.data.service.SystemService;
import com.concise.demoblog.data.entity.System;
import com.concise.demoblog.web.controller.util.WebUtil;

@Controller
public class IndexController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private WebUtil webUtil;
	@Autowired
	private SystemService systemService;
	@RequestMapping("index.html")
	public String index(Model model){
		//得到文章信息
		List<Article> articles = articleService.getArticles();
		webUtil.getSidebarInfo(model);
		model.addAttribute("articles", articles);
		
		//首次打开网站
		ServletContext application = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		//得到网站地址
		System system = systemService.getSystem();
		application.setAttribute("url",system.getUrl() );
		application.setAttribute("siteName",system.getTitle() );
		return "index";
	}
	
	
	@RequestMapping("category/{name}.html")
	public String category(@PathVariable("name") String name , Model model){
		int id = categoryService.getIdByName(name);
		List<Article> articles = articleService.getArticlesByCategoryId(id);
		model.addAttribute("articles", articles);
		model.addAttribute("categoryName", name);
		webUtil.getSidebarInfo(model);
		return "index";
	}

	@RequestMapping("searchByKeyword.do")
	public String getArticlesBykeyword(String keyword , Model model){
		List<Article> articles  = articleService.getArticlesBykeyword(keyword);
		model.addAttribute("articles", articles);
		model.addAttribute("searchKeyWord", keyword);
		webUtil.getSidebarInfo(model);
		return "index";
	}
}
