package com.zztl.testapi.vo;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description 用户信息
 * @date 2018/12/29
 */

public class UserVo implements Serializable {

    private int userId;
    private String username;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public UserVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserVo() {
    }
}
