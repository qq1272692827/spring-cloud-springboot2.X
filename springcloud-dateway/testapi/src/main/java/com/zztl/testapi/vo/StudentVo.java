package com.zztl.testapi.vo;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description 学生信息
 * @date 2018/12/29
 */

public class StudentVo implements Serializable {

    private int sid;
    private String sname;
    private int gender;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public StudentVo() {
    }

    public StudentVo(int sid, String sname, int gender) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
    }
}
