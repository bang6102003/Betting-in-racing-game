/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.DAO;

import com.example.src1.Database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.src1.Model.Player_Item;
import com.example.src1.Model.User;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author admin
 */
public class Player_ItemDAO implements interfaceDAO<Player_Item>{
    public static Player_ItemDAO getInstance(){
        return new Player_ItemDAO();
    }

    @Override
    public int insert(Player_Item t) {
        try {
            // Tao ket noi CSDL
            Connection con = JDBCUtil.getConnection();
            // Thuc thi cau lenh SQL
            String sql = "INSERT INTO player_item VALUES(?,?)";
            
            // Tao doi tuong statement
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1, t.getItem_ID());
            pst.setString(2, t.getPlayer_User());
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
    public int delete(Player_Item t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Player_Item t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updatePoint(int player_point, String player_user) {
        return 0;
    }

    @Override
    public ArrayList<Player_Item> selectAll() {
         ArrayList<Player_Item> ketqua = new ArrayList<Player_Item>();
        try {
            // Tao ket noi CSDL
            Connection con = JDBCUtil.getConnection();
            // Tao doi tuong statement
            Statement st = con.createStatement();
            // Thuc thi cau lenh SQL
            String sql = "SELECT * FROM player_item";
            ResultSet rs = st.executeQuery(sql);
            //
            while(rs.next()){
                String item_ID = rs.getString("item_ID");
                String player_User = rs.getString("player_User");

                
                Player_Item user = new Player_Item(item_ID, player_User);
                ketqua.add(user);
            }

            // Ngat ket noi
            JDBCUtil.closeConnection(con);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Player_Item selectById(Player_Item t) {
       Player_Item taikhoan = new Player_Item("","");
      
        try {
             //Khởi tạo kết nối database
            Connection con = JDBCUtil.getConnection();
            //Tao cau lenh SQL
            String sql = "SELECT * FROM player_item WHERE item_ID = ?";
            //Tạo đối tượng statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getItem_ID());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String item_ID = rs.getString("item_ID");
                String player_User = rs.getString("player_User");
                taikhoan = new Player_Item(item_ID, player_User);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return taikhoan;
    }

    @Override
    public ArrayList<Player_Item> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
