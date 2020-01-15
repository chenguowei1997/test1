package cn.itcast.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: CGW
 * @Date: 2020/1/4 15:01
 */
public class Permission implements Serializable {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;

    private int flag;//用于展示页面是否选中复选框的标志

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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
