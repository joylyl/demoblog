package com.concise.demoblog.web.controller.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.concise.demoblog.data.entity.Category;
import com.concise.demoblog.data.service.CategoryService;

@Component
public class WebUtil {

	@Autowired
	private CategoryService categoryService;
	
	public void getSidebarInfo(Model model){
		//得到侧边栏信息
		List<Category> categories = categoryService.getByKeyword("");	
		model.addAttribute("categories", categories);
	}
}
