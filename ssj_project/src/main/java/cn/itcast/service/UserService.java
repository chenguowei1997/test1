package cn.itcast.service;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 14:54
 */
public interface UserService {
    /*查询所有*/
    List<User> findAll() throws Exception;

    /*新增用户 */
    void save(User user) throws Exception;

    /*根据id查询用户拥有的角色信息*/
    List<Role> findUserRolesByUid(String id) throws Exception;

    /*更改角色操作*/
    void updateUserRoles(String userId, String[] ids) throws Exception;

    /*根据id删除用户信息*/
    void deleteById(String ids) throws Exception;

    /*查询详情*/
    User findUserById(String id) throws Exception;

    /*登录*/
    User login(String username, String password) throws Exception;
}
