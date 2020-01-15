package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/4 14:56
 */
@Controller
@RequestMapping("/pages")
public class PagesController {

    @Autowired
    private PageService pageService;

    /*查询所有*/
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception{
        List<Permission> permissionList = pageService.findAll();
        model.addAttribute("permissionList",permissionList);
        return "permission-list";
    }


    //新增用户
    @RequestMapping("save")
    public String save (Permission permission) throws Exception{
        pageService.save(permission);
        return "redirect:/pages/findAll";
    }
}
