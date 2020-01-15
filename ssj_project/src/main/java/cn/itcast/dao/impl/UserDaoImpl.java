package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/3 14:54
 */
/*持久层操作*/
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询所有
    @Override
    public List<User> findAll() throws Exception {
        return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<User>(User.class));
    }

    //新增用户
    @Override
    public void save(User user) throws Exception{
        jdbcTemplate.update("insert into users values(?,?,?,?,?,?)",
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoneNum(),
                user.getStatus());
    }

    /*根据id查询用户拥有的角色信息*/
    @Override
    public List<Role> findUserRolesByUid(String id) throws Exception{
        return jdbcTemplate.query("select * from role where id in(select roleId from users_role where userId=?)",
                new BeanPropertyRowMapper<Role>(Role.class),id);
    }

    /*添加用户角色信息操作*/
    @Override
    public void addUserRoles(String userId, String rid) throws Exception {
        jdbcTemplate.update("insert into users_role values(?,?)",userId,rid);
    }

    /*根据id删除用户信息*/
    @Override
    public void deleteUserById(String uid) throws Exception {
        jdbcTemplate.update("delete from users where id= ? ",uid);
    }

    /*拿当前用户的id去清除用户关联表中的关联信息*/
    @Override
    public void deleteUserRolesById(String userId) throws Exception {
        jdbcTemplate.update("delete from users_role where userid=?" ,userId);
    }

    @Override
    public User findById(String id) {
        User u = null;

        try {
            u=jdbcTemplate.queryForObject("select * from users where id = ? " ,new BeanPropertyRowMapper<User>(User.class),id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    /*登录查询*/
    @Override
    public User findUserAndPassword(String username, String password) {
        User u = null;
        try {
            u= jdbcTemplate.queryForObject("select * from users where username = ? and password = ?",new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return u;
    }




}
