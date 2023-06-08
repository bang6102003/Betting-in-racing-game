/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.Database;
import com.example.src1.Model.User;
import com.example.src1.Model.User_ToanCuc;
import oracle.jdbc.driver.OracleDriver;
import com.example.src1.Model.User_ToanCuc;
import java.sql.*;

/**
 *
 * @author admin
 */
public class JDBCUtil {
    public static Connection getConnection(){
        Connection c =null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "bang";
            String password = "1";
            c = DriverManager.getConnection(url, username, password);  
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
    public static void closeConnection(Connection c){
        if(c != null){
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
