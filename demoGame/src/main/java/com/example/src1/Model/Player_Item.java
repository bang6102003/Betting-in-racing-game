/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.Model;

/**
 *
 * @author admin
 */
public class Player_Item {
    private String item_ID;
    private String player_User;

    public Player_Item(String item_ID, String player_User) {
        this.item_ID = item_ID;
        this.player_User = player_User;
    }

    public Player_Item() {
    }

    public String getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(String item_ID) {
        this.item_ID = item_ID;
    }

    public String getPlayer_User() {
        return player_User;
    }

    public void setPlayer_User(String player_User) {
        this.player_User = player_User;
    }
    
}
