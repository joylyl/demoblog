package com.concise.web.util;

import com.concise.entity.Article;
import com.concise.entity.Category;
import com.concise.service.IArticleService;
import com.concise.service.ICategoryService;
import com.concise.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.ContextLoader;

import java.util.List;
import java.util.UUID;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Component
public class WebUtil {

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private ISystemService iSystemService;

    /**
     * 侧边栏数据
     */
    public void getSidebarInfo(){
        //得到侧边栏信息
        List<Category> categories = iCategoryService.getByKeyword("");
//        model.addAttribute("categories",categories);
        ContextLoader.getCurrentWebApplicationContext().getServletContext().setAttribute("categories", categories);
    }

    /**
     * 首页数据
     */
    public void index(){
        getSidebarInfo();
        com.concise.entity.System system =iSystemService.getSystem();
        ContextLoader.getCurrentWebApplicationContext().getServletContext().setAttribute("system",system);
    }

    /**
     * 使用UUID.randomUUID() 来生成id，并去掉“-”连字符
     *
     * @return
     */
    public String getId() {
        String id = UUID.randomUUID().toString();
        StringBuilder buf = new StringBuilder(32);
        buf.append(id.substring(0, 8)).append(id.substring(9, 13))
                .append(id.substring(14, 18)).append(id.substring(19, 23))
                .append(id.substring(24));
        return buf.toString();
    }
}
