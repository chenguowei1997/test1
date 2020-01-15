package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 14:53
 */
public interface UserDao {
    /*查询所有*/
    List<User> findAll() throws Exception;

    /*新增用户*/
    void save(User user) throws Exception;

    /*根据id查询用户拥有的角色信息*/
    List<Role> findUserRolesByUid(String id) throws Exception;

    /*添加用户角色信息操作*/
    void addUserRoles(String userId, String rid) throws Exception;

    /*根据id删除用户信息*/
    void deleteUserById(String uid) throws Exception;

    /*拿当前用户的id去清除用户关联表中的关联信息*/
    void deleteUserRolesById(String userId) throws Exception;

    /*查询详情*/
    User findById(String id);

    User findUserAndPassword(String username, String password);

    /*登录根据用户名密码判断*/

}
