package com.baichuan.campus_assistant.db.entity;
import cn.bmob.v3.BmobUser;

/**
 * Created by baichuan on 2017/2/25.
 */

public class MyUser extends BmobUser {
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 昵称
     */
    private String nickname;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
