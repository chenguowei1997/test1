package cn.itcast.dao;

import cn.itcast.domain.Permission;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/4 15:04
 */
public interface PageDao {

    /*查询所有*/
    List<Permission> findAll() throws Exception;

    /*新增权限*/
    void save(Permission permission) throws Exception;
}
