/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.exolab.castor.types.Time;
import view.GiaoDienTinhDiem_Frame;
import view.MainView;

/**
 *
 * @author admin
 */
public class TinhDiem_controller {
    public TinhDiem_controller(int ketqua) {
        GiaoDienTinhDiem_Frame TD = new GiaoDienTinhDiem_Frame();
        TD.setLocationRelativeTo(null);
        TD.setResizable(false);
        TD.setVisible(true);
        if(ketqua == 1){
            TD.lost_win.setText("THẮNG RỒI NÈ");
            TD.lost_win.setForeground(Color.red);
            TD.XepThu1.setText("ĐẾN VÀ RINH CÚP THÔI NÀO");
            
        }else if(ketqua == 2){
            TD.lost_win.setText("THIẾU CHÚT NỮA");
            TD.lost_win.setForeground(Color.BLUE);
            TD.XepThu2.setText("BẠN ĐÂY NÈ");
        }else{
            TD.lost_win.setText("THUA MẤT RỒI");
            TD.lost_win.setForeground(Color.GREEN);
            TD.XepThu3.setText("ĐÁY XÃ HỘI");
        }
    }

    public TinhDiem_controller() {
        MainView mv = new MainView();
        mv.setLocationRelativeTo(null);
        mv.setVisible(true);
    }
    
}
