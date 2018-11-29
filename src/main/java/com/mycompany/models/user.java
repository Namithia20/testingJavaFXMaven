/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author Usuario
 */
public class user {
    private Integer id;
    private String nick;
    private int firstLogin;

    public user(Integer id, String nick, int firstLog) {
        this.id = id;
        this.nick = nick;
        this.firstLogin = firstLog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(int firstLogin) {
        this.firstLogin = firstLogin;
    }
    
    
}
