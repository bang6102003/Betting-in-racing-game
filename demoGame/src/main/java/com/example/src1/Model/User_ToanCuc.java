/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.Model;

/**
 *
 * @author admin
 */
public class User_ToanCuc {
    private static String player_user;
    private static String player_pass;
    private static String player_name;
    private static int player_point;

    public User_ToanCuc() {
    }

    public static String getPlayer_user() {
        return player_user;
    }

    public static void setPlayer_user(String player_user) {
        User_ToanCuc.player_user = player_user;
    }

    public static String getPlayer_pass() {
        return player_pass;
    }

    public static void setPlayer_pass(String player_pass) {
        User_ToanCuc.player_pass = player_pass;
    }

    public static String getPlayer_name() {
        return player_name;
    }

    public static void setPlayer_name(String player_name) {
        User_ToanCuc.player_name = player_name;
    }

    public static int getPlayer_point() {
        return player_point;
    }

    public static void setPlayer_point(int player_point) {
        User_ToanCuc.player_point = player_point;
    }
    
}
