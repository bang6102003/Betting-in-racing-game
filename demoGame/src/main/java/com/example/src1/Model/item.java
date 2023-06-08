/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.Model;

/**
 *
 * @author admin
 */
public class item {
    private String item_ID;
    private String item_name;
    private int item_cost;

    public item() {
    }

    public item(String item_ID, String item_name, int item_cost) {
        this.item_ID = item_ID;
        this.item_name = item_name;
        this.item_cost = item_cost;
    }

    public String getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(String item_ID) {
        this.item_ID = item_ID;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_cost() {
        return item_cost;
    }

    public void setItem_cost(int item_cost) {
        this.item_cost = item_cost;
    }
    
}
