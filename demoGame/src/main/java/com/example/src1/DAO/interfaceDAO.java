/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.src1.DAO;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface interfaceDAO<T> {
    public int insert(T t);
    
    public int delete(T t);

    public int update(T t);
    int updatePoint(int player_point, String player_user);

    public ArrayList<T> selectAll();
    
    public T selectById(T t);
    
    public ArrayList<T> selectByCondition(String condition);
}
