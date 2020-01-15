package cn.itcast.dao.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 20:21
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询所有
    @Override
    public List<Role> findAll() throws Exception {
        return jdbcTemplate.query("select * from role ", new BeanPropertyRowMapper<Role>(Role.class));
    }

    /*新增用户*/
    @Override
    public void save(Role role) throws Exception {
        jdbcTemplate.update("insert into role  values (?,?,?)", role.getId(), role.getRoleName(), role.getRoleDesc());
    }

    /*根据id删除角色*/
    @Override
    public void deleteRoleById(String rid) throws Exception {
        jdbcTemplate.update("delete from role where id=?", rid);
    }

    /*根据id删除用户角色关联的数据信息*/
    @Override
    public void deleteUserRoleById(String rid) throws Exception {
        jdbcTemplate.update("delete from user_role where roleid=?", rid);
    }

    /*根据id删除角色权限表中的数据信息*/
    @Override
    public void deleteRolePermissionById(String rid) throws Exception {
        jdbcTemplate.update("delete form role_permission where roleId = ?", rid);
    }

    /*根据id查询角色的权限信息*/
    @Override
    public List<Permission> findRolePermissionByRid(String id) throws Exception {
        /*Permission p = null;
        try {
            p= (Permission) jdbcTemplate.query("select * from  permission where id in(select permissionid from role-permission where roleid=?)",new BeanPropertyRowMapper<Permission>(Permission.class),id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return (List<Permission>) p;*/
        return jdbcTemplate.query("select * from  permission where id in(select permissionid from role_permission where roleid=?)", new BeanPropertyRowMapper<Permission>(Permission.class), id);
    }

}
