package com.concise.web.controller.admin;

import com.concise.entity.Tag;
import com.concise.service.ITagService;
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
@RequestMapping("admin/tag")
public class TagController {

    @Autowired
    private ITagService iTagService;

    @RequestMapping("index.html")
    public String index(Model model){
        List<Tag> tags = iTagService.getTags();
        model.addAttribute("tags",tags);
        return "admin/tag/index";
    }

    @RequestMapping(value="add.do" , method = RequestMethod.POST)
    public String execAdd(@ModelAttribute("tag") Tag tag){
        iTagService.add(tag);
        return "redirect:/admin/tag/index.html";
    }

    @RequestMapping(value = "update.do" ,method = RequestMethod.POST)
    public String execUpdate(@ModelAttribute("tag") Tag tag){
        System.out.print(tag.getId());
        System.out.print(tag.getName());
        System.out.print(tag.getAlias());
        iTagService.update(tag);
        return "redirect:/admin/tag/index.html";
    }

    @RequestMapping("delete.do")
    public String delete(Integer id){
        iTagService.delete(id);
        return "redirect:/admin/tag/index.html";
    }
}
