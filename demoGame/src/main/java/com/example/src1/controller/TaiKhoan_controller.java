package com.example.src1.controller;
import com.example.src1.Model.User;
public class TaiKhoan_controller {
    private User user;
    public TaiKhoan_controller(User user) {
        this.user = user;
    }
    public TaiKhoan_controller(){

    }
    public User getUser() {
        return user;
    }


}