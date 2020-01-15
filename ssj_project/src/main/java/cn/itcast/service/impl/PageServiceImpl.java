package cn.itcast.service.impl;

import cn.itcast.dao.PageDao;
import cn.itcast.domain.Permission;
import cn.itcast.service.PageService;
import cn.itcast.utils.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/4 15:03
 */@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageDao pageDao;

    /*查询所有*/
    @Override
    public List<Permission> findAll() throws Exception {
        return pageDao.findAll();
    }

    /*新增权限*/
    @Override
    public void save(Permission permission) throws Exception {
        permission.setId(Uuid.getId());
        pageDao.save(permission);
    }
}
