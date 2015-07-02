package com.concise.web.controller.admin;

import com.concise.service.ICategoryService;
import com.concise.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 刘印龙 on 2015/6/8.
 */
@Controller
@RequestMapping("admin/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value="index.html")
    public String index(Model model){
        List<Category> categories = iCategoryService.getByKeyword("");
        model.addAttribute("categories",categories);
        return "admin/category/index";
    }

    @RequestMapping(value="add.do" , method = RequestMethod.POST)
    public String execAdd(@ModelAttribute("category") Category category){
        iCategoryService.add(category);
        return "redirect:/admin/category/index.html";
    }

    @RequestMapping(value="update.do" , method = RequestMethod.POST)
    public String execUpdate(@ModelAttribute("category") Category category ){
        iCategoryService.update(category);
        return "redirect:/admin/category/index.html";
    }

    @RequestMapping("delete.do")
    public String delete(Integer id){
        iCategoryService.delete(id);
        return "redirect:/admin/category/index.html";
    }
}
