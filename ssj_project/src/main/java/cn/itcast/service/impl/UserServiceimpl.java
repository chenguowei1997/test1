package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: CGW
 * @Date: 2020/1/3 14:56
 */
/*业务层操作*/
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*查询所有*/
    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    /*新增用户*/
    @Override
    public void save(User user) throws Exception {
        //给user对象中的id赋值一个唯一的字符串
        //从工具类中获取唯一的id
        user.setId(Uuid.getId());
        userDao.save(user);
    }

    /*根据id查询用户拥有的角色信息*/
    @Override
    public List<Role> findUserRolesByUid(String id) throws Exception {
        return userDao.findUserRolesByUid(id);
    }

    /*更改角色操作*/
    @Override
    public void updateUserRoles(String userId, String[] ids) throws Exception {
        if (ids != null && ids.length > 0) {
            userDao.deleteUserRolesById(userId);//拿当前用户的id去清除用户关联表中的关联信息
            for (String rid : ids) {
                userDao.addUserRoles(userId,rid);
            }
        }
    }

    /*根据id删除用户信息*/
    @Override
    public void deleteById(String ids) throws Exception {
        if (ids!=null && ids.length()>0){
            String[] uids = ids.split(",");
            for (String uid : uids) {
                userDao.deleteUserRolesById(uid);
                userDao.deleteUserById(uid);
            }
        }
    }

    /*查询详情*/
    @Override
    public User findUserById(String id) throws Exception {
        User user = userDao.findById(id);
        //根据id获取当前用户所拥有的角色信息
        List<Role> roleList = userDao.findUserRolesByUid(id);
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userDao.findUserAndPassword(username,password);
        return user;
    }

    /*登录*/

}
