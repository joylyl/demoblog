package com.concise.demoblog.web.controller;

import java.io.IOException;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.concise.demoblog.data.entity.Article;
import com.concise.demoblog.data.entity.Tag;
import com.concise.demoblog.data.service.ArticleService;
import com.concise.demoblog.data.service.CategoryService;
import com.concise.demoblog.data.service.TagService;
import com.concise.demoblog.web.controller.util.WebUtil;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private WebUtil webUtil;
	@Autowired
	private TagService tagService;

	//返回页面的提示消息
	private static String MESSAGE_STRING = "";
	//返回页面的提示code
	private static String MESSAGE_CODE = "";
	
	
	/**
	 * 未完成功能
	 * 
	 * 
	 * 修改用户 isrecover 没有传进来
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	/**
	 * 通过static url 查看文章内容
	 * @param staticurl
	 * @param model
	 * @return
	 */
	@RequestMapping("info/{staticurl}.html")
	public String getInfoById(@PathVariable("staticurl") String staticurl , Model model){
		Article article = articleService.getArticleByStaticURL(staticurl);
		model.addAttribute("article", article);
		webUtil.getSidebarInfo(model);
		return "article";
	}
	
	/**
	 * 跳转到添加新文章页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="admin/newarticle.html",method = RequestMethod.GET)
	public String go_addNewArticle(Model model){
		webUtil.getSidebarInfo(model);
		addTagsToModel(model);
		return "article_update";
	}
	
	/**
	 * 执行添加新文章功能
	 * @param article
	 * @param model
	 * @return
	 */
	@RequestMapping(value="admin/newarticle.html",method = RequestMethod.POST)
	public String addNewArticle(@ModelAttribute Article article , Model model){
		try {
			article.setContent(new Markdown4jProcessor().process(article.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean result = articleService.add(article);
		
		addMessaegToModel(article.getTitle()+" 添加成功",article.getTitle()+" 添加失败",model ,result);
		
		//添加失败返回已填写文章内容
		model.addAttribute("article", article);
		
		return "article_update";
	}
	
	/**
	 * 设置通用Model值
	 * @param trueMessage 正确的提示内容
	 * @param errorMessage 错误的提示内容
	 * @param model Model对象
	 * @param result 执行结果
	 */
	private void addMessaegToModel(String trueMessage , String errorMessage , Model model , boolean result){
		if(result){
			MESSAGE_STRING = trueMessage;
			MESSAGE_CODE = "1";
			model.addAttribute("message_string", MESSAGE_STRING);
			model.addAttribute("messaeg_code", MESSAGE_CODE);
		}
		else{
			MESSAGE_STRING = errorMessage;
			MESSAGE_CODE = "0";
			model.addAttribute("message_string", MESSAGE_STRING);
			model.addAttribute("messaeg_code", MESSAGE_CODE);
		}
	}
	
	/**
	 * 得到Tag并添加到Model
	 * @param model
	 */
	private void addTagsToModel(Model model){
		model.addAttribute("tags", tagService.getTags());
	}
	
	/**
	 * 跳转到修改页面
	 * @param staticurl 文章的静态URL
	 * @param model
	 * @return
	 */
	@RequestMapping(value="admin/updatearticle/{staticurl}.html" , method = RequestMethod.GET)
	public String go_updateArticle(@PathVariable("staticurl") String staticurl , Model model){
		Article article = articleService.getArticleByStaticURL(staticurl);
		webUtil.getSidebarInfo(model);
		addTagsToModel(model);
		model.addAttribute("article", article);
		return "article_update";
	}
	
	/**
	 * 执行文章的修改功能
	 * @param article
	 * @param model
	 * @return
	 */
	@RequestMapping(value="admin/updatearticle.do" , method = RequestMethod.POST)
	public String updateArticle(@ModelAttribute Article article , Model model){
		
		System.out.println(article.getIsrecover()+":------------:");
		
		boolean result = articleService.update(article);
		addMessaegToModel(article.getTitle()+" 修改成功",article.getTitle()+" 修改失败",model ,result);
		model.addAttribute("article", article);
		return "article_update";
	}
	
}
