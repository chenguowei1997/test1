package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.PageService;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 20:27
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PageService pageService;

    //查询所有
    @RequestMapping("findAll")
    public String  findAll(Model model) throws Exception{
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }

    //新增用户
    @RequestMapping("save")
    public String save (Role role) throws Exception{
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    //根据id删除角色信息
    @RequestMapping("deleteById")
    public String deleteById(String ids) throws Exception{
        roleService.deleteById(ids);
        return "redirect:/role/findAll";
    }

    /*1.查询所有权限信息
    * 2.查询当前角色拥有的权限信息
    * */
    @RequestMapping("/findRolePermission/{rid}")
    public String findRolePermission(@PathVariable("rid")String id, Model model) throws Exception{
        List<Permission> permissionList = pageService.findAll();

        /*根据id查询角色拥有的权限信息*/
        List<Permission> rolePermissionByRid = roleService.findRolePermissionByRid(id);
        for (Permission permission : permissionList) {
            for (Permission permission1 : rolePermissionByRid) {
                if (permission.getId().equals(permission1.getId())){
                    permission.setFlag(1);
                }
            }
        }
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }
}
