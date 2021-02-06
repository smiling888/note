package com.chase.config;


/**
 * 普通类作为配置类导入
 * 在启动类加Import即可
 * Date: 2021/2/6
 **/

public class MySqlConn {
    private String username = "root";

    public MySqlConn() {
        System.out.println(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
