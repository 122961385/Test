package cn.sw.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String username;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    private Integer age;

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
