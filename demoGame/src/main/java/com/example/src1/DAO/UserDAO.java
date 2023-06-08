/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.DAO;

import com.example.src1.Database.JDBCUtil;
import com.example.src1.Model.User;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author admin
 */
public class UserDAO implements interfaceDAO<User>{
    public static UserDAO getInstance(){
        return new UserDAO();
    }
    @Override
    public int insert(User t) {
       try {
            // Tao ket noi CSDL
            Connection con = JDBCUtil.getConnection();
            // Thuc thi cau lenh SQL
            String sql = "INSERT INTO player VALUES(?,?,?,?)";
            
            // Tao doi tuong statement
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1, t.getPlayer_user());
            pst.setString(2, t.getPlayer_pass());
            pst.setString(3, t.getPlayer_name());
           pst.setString(4, String.valueOf(10));
            //
            pst.executeUpdate();
            // Ngat ket noi
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;     
    }

    @Override
    public int delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(User user) {
        return 0;
    }


    @Override
    public int updatePoint(int player_point, String player_user) {
        try {
            // Tao ket noi CSDL
            Connection con = JDBCUtil.getConnection();
            // Thuc thi cau lenh SQL
            String sql = "UPDATE PLAYER SET PLAYER_POINT=? WHERE PLAYER_USER=?";

            // Tao doi tuong statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, player_point);
            pst.setString(2, player_user);
            //
            pst.executeUpdate();
            // Ngat ket noi
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User selectById(User t) {
        User taikhoan = new User("0", "0", "0", 0);
      
        try {
             //Khởi tạo kết nối database
            Connection con = JDBCUtil.getConnection();
            //Tao cau lenh SQL
            String sql = "SELECT * FROM player WHERE player_User = ?";
            //Tạo đối tượng statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getPlayer_user());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String user = rs.getString("player_User");
                String pass = rs.getString("player_Password");
                String name = rs.getString("player_Name");
                int point = rs.getInt("player_Point");
                taikhoan = new User(user, pass, name, point);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return taikhoan;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    public static UserDAO 
    
}
