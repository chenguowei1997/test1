package cn.itcast.dao;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 20:20
 */
public interface RoleDao {

    /*查询所有*/
    List<Role> findAll() throws Exception;

    /*新增用户*/
    void save(Role role) throws Exception;

    /*根据id删除角色*/
    void deleteRoleById(String rid) throws Exception;

    /*根据id删除用户角色表中的关联的数据信息*/
    void deleteUserRoleById(String rid) throws Exception;

    /*根据id删除用户权限表中的关联数据信息*/
    void deleteRolePermissionById(String rid) throws Exception;

    /*根据id查询角色的权限信息*/
    List<Permission> findRolePermissionByRid(String id) throws Exception;
}
