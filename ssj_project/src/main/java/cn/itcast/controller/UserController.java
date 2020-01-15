package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 18:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /*注入service*/
    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;



    /*登录*/
    @RequestMapping("/login")
    public String login(String username , String password, HttpSession session) throws Exception {
        User user = service.login(username,password);
        if (user!=null){
            //登录成功 将user存储到session域中
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    /*查询详情*/
    @RequestMapping("/findUserById/{uid}")
    public String findUserById(@PathVariable("uid")String id,Model model)throws Exception{
        User user =  service.findUserById(id);
        model.addAttribute("user",user);
        return "user-show";
    }

    /*根据id删除用户信息*/
    @RequestMapping("/deleteById")
    public String deleteById(String ids) throws Exception{
        service.deleteById(ids);
        return "redirect:/user/findAll";
    }


    /*更改角色操作
    * 1.当前用户id
    * 2.所选中角色id
    * */
    @RequestMapping("/updateUserRoles")
    public String updateUserRoles(String userId,String[] ids) throws Exception {
        service.updateUserRoles(userId,ids);
        return "redirect:/user/findAll";
    }


    /*1.查询所有角色信息
      2.查询当前用户已拥有的角色信息
    * */
    @RequestMapping("/findUserRoles/{uid}")
    public String findUserRoles(@PathVariable("uid") String id , Model model) throws Exception{
        /*所有的角色信息*/
        List<Role> roleList = roleService.findAll();

        /*根据id查询用户拥有的角色信息*/
        List<Role> userRoles = service.findUserRolesByUid(id);
        for (Role role : roleList) {
            for (Role userRole : userRoles) {
                if (role.getId().equals(userRole.getId())){
                    role.setFlag(1);
                }
            }
        }

        model.addAttribute("roleList",roleList);
        model.addAttribute("uid",id);
        return "user-role-add";
    }


    /*新增操作*/
    @RequestMapping("/save")
    public String save(User user) throws Exception{
        /*user:接收前端页面数据缺少一个id,此时的ID是字符串不是自增整型的*/
        service.save(user);
        return "redirect:/user/findAll";
    }

    /*遍历操作*/
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception{
        List<User> userList = service.findAll();
        model.addAttribute("userList" ,userList);
        return "user-list";
    }
   /* @ResponseBody
   public List<User> findAll() throws Exception{
        return service.findAll();
    }*/
}
