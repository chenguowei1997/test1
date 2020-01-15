package cn.itcast.domain;

import java.io.Serializable;

/**
 * @Author: CGW
 * @Date: 2020/1/3 20:18
 */
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String roleDesc;

    private int flag;//用于页面是否选中复选框的标识 1选中 0不选中

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
