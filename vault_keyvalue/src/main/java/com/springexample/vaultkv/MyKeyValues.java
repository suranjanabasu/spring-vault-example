package com.springexample.vaultkv;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("examplekv")
public class MyKeyValues {

    private String username;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
