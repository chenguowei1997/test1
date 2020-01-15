package cn.itcast.service;

import cn.itcast.domain.Permission;
import cn.itcast.domain.User;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/4 14:58
 */
public interface PageService {
    /*查询所有*/
    List<Permission> findAll() throws Exception;

    /*新增权限*/
    void save(Permission permission) throws Exception;
}
