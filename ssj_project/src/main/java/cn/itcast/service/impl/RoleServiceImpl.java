package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import cn.itcast.utils.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 20:25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /*查询所有*/
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    /*新增用户*/
    @Override
    public void save(Role role) throws Exception {
        role.setId(Uuid.getId());
        roleDao.save(role);
    }

    /*根据id删除角色信息*/
    @Override
    public void deleteById(String ids) throws Exception {
        if (ids != null && ids.length() > 0) {
            String[] rids = ids.split(",");
            for (String rid : rids) {
                roleDao.deleteRolePermissionById(rid);
                roleDao.deleteUserRoleById(rid);
                roleDao.deleteRoleById(rid);
            }
        }
    }

    @Override
    public List<Permission> findRolePermissionByRid(String id) throws Exception {
        return roleDao.findRolePermissionByRid(id);
    }
}
