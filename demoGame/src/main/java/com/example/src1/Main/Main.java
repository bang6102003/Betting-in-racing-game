/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.src1.Main;

import javax.swing.JFrame;
import com.example.src1.view.LoginJFrame;

/**
 *
 * @author admin
 */
public class Main extends JFrame{
    public static void main(String[] args) {
       LoginJFrame lg = new LoginJFrame();
       lg.setResizable(false);
       lg.setLocationRelativeTo(null);
       lg.setVisible(true);
    }
}
