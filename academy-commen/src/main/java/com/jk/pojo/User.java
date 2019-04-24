package com.jk.pojo;


/**
 * @program: mavenmodule
 * @Date: 2019/4/19 19:30
 * @Author: Mr.Deng
 * @Description:
 */

public class User {

    private Integer uid;

    private String username;

    private String password;

    private String vcode;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vcode='" + vcode + '\'' +
                '}';
    }
}
