package cn.itcast.service;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 20:24
 */
public interface RoleService {
    /*查询所有*/
    List<Role> findAll() throws Exception;

    /*新增用户*/
    void save(Role role) throws Exception;

    /*根据id删除角色信息*/
    void deleteById(String ids) throws Exception;

    /*根据id查询当前角色的权限信息*/
    List<Permission> findRolePermissionByRid(String id) throws Exception;
}
