package com.xiaotang.starrysky.model.dao;

/**
 * 文件名: Userdatadb
 * 创建者: 友
 * 创建日期: 2020/10/21 16:47
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */
public class Userdatadb {

    private String name;
    private String accout;
    private String password;

    @Override
    public String toString() {
        return "Userdatadb{" +
                ", name='" + name + '\'' +
                ", accout='" + accout + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Userdatadb(String name, String accout, String password) {

        this.name = name;
        this.accout = accout;
        this.password = password;
    }

    public Userdatadb() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
