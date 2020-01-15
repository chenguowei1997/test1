package cn.itcast.dao.impl;

import cn.itcast.dao.PageDao;
import cn.itcast.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/4 15:05
 */
@Repository
public class PageDaoImpl implements PageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*查询所有*/
    @Override
    public List<Permission> findAll() throws Exception {
        return jdbcTemplate.query("select * from permission",new BeanPropertyRowMapper<Permission>(Permission.class));
    }

    /*添加角色*/
    @Override
    public void save(Permission permission) throws Exception {
        jdbcTemplate.update("insert into permission values(?,?,?)",permission.getId(),permission.getPermissionName(),permission.getUrl());
    }
}
