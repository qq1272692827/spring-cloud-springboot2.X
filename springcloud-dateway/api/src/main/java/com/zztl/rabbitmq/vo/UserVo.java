package com.zztl.rabbitmq.vo;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description 实体对象
 * @date 2019/1/10
 */

public class UserVo implements Serializable {

    private String username;
    private int gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public UserVo() {
    }

    public UserVo(String username, int gender) {
        this.username = username;
        this.gender = gender;
    }



}
