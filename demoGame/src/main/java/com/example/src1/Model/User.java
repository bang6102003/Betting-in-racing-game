/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.Model;

/**
 *
 * @author admin
 */
public class User {
    private String player_user;
    private String player_pass;
    private String player_name;
    private int player_point;

    public User() {
    }

    public User(String player_user, String player_pass, String player_name, int player_point) {
        this.player_user = player_user;
        this.player_pass = player_pass;
        this.player_name = player_name;
        this.player_point = player_point;
    }

    public String getPlayer_user() {
        return player_user;
    }

    public void setPlayer_user(String player_user) {
        this.player_user = player_user;
    }

    public String getPlayer_pass() {
        return player_pass;
    }

    public void setPlayer_pass(String player_pass) {
        this.player_pass = player_pass;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getPlayer_point() {
        return player_point;
    }

    public void setPlayer_point(int player_point) {
        this.player_point = player_point;
    }
    
}
