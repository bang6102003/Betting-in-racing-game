/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.src1.view;

import com.example.src1.DAO.UserDAO;
import com.example.src1.Model.User;
import com.example.src1.Model.User_ToanCuc;
import com.example.src1.controller.Controller_Login;
import javax.swing.JOptionPane;


public class LoginJFrame extends javax.swing.JFrame {

    public LoginJFrame() {
        initComponents();
        setTitle("Login");
        Sigin_panel.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Login_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DangNhap_button = new javax.swing.JButton();
        DangKy_button = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        Sigin_panel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TenTaiKhoanDangKy_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TenDangNhapDangKy_text = new javax.swing.JTextField();
        MatKhauDangKy_text = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        XacNhanDangKy_button = new javax.swing.JButton();
        HuyDangKy_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 34, 56));
        setBounds(new java.awt.Rectangle(2, 3, 10, 20));

        jPanel1.setBackground(new java.awt.Color(24, 34, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 0, 204)));
        jPanel1.setLayout(null);

        Login_panel.setBackground(new java.awt.Color(24, 34, 56));
        Login_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 102), new java.awt.Color(0, 255, 102), new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255)));

        jSeparator1.setBackground(new java.awt.Color(24, 34, 56));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(24, 34, 56));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_icon.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock_icon.png"))); // NOI18N

        DangNhap_button.setBackground(new java.awt.Color(51, 255, 51));
        DangNhap_button.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        DangNhap_button.setForeground(new java.awt.Color(0, 0, 0));
        DangNhap_button.setText("Đăng nhập");
        DangNhap_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangNhap_buttonActionPerformed(evt);
            }
        });

        DangKy_button.setBackground(new java.awt.Color(255, 51, 0));
        DangKy_button.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        DangKy_button.setForeground(new java.awt.Color(0, 0, 0));
        DangKy_button.setText("Đăng ký");
        DangKy_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangKy_buttonActionPerformed(evt);
            }
        });

        txtUsername.setBackground(new java.awt.Color(24, 34, 56));
        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("Tên đăng nhập");
        txtUsername.setBorder(null);
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Đăng nhập");

        txtPassword.setBackground(new java.awt.Color(24, 34, 56));
        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("........");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout Login_panelLayout = new javax.swing.GroupLayout(Login_panel);
        Login_panel.setLayout(Login_panelLayout);
        Login_panelLayout.setHorizontalGroup(
            Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Login_panelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Login_panelLayout.createSequentialGroup()
                            .addComponent(DangNhap_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DangKy_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Login_panelLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator2)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Login_panelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, 33))
        );
        Login_panelLayout.setVerticalGroup(
            Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_panelLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Login_panelLayout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Login_panelLayout.createSequentialGroup()
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(Login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangKy_button)
                    .addComponent(DangNhap_button))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1.add(Login_panel);
        Login_panel.setBounds(360, 0, 297, 283);

        Sigin_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 51), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(24, 34, 56));
        jTextField1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Đăng ký");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Nhập tên tài khoản");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Nhập tên đăng nhập");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setText("Nhập mật khẩu");

        XacNhanDangKy_button.setBackground(new java.awt.Color(0, 255, 51));
        XacNhanDangKy_button.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        XacNhanDangKy_button.setForeground(new java.awt.Color(0, 0, 0));
        XacNhanDangKy_button.setText("Xong");
        XacNhanDangKy_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XacNhanDangKy_buttonActionPerformed(evt);
            }
        });

        HuyDangKy_button.setBackground(new java.awt.Color(255, 51, 51));
        HuyDangKy_button.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        HuyDangKy_button.setForeground(new java.awt.Color(0, 0, 0));
        HuyDangKy_button.setText("Hủy");
        HuyDangKy_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyDangKy_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Sigin_panelLayout = new javax.swing.GroupLayout(Sigin_panel);
        Sigin_panel.setLayout(Sigin_panelLayout);
        Sigin_panelLayout.setHorizontalGroup(
            Sigin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Sigin_panelLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(Sigin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Sigin_panelLayout.createSequentialGroup()
                        .addComponent(XacNhanDangKy_button, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HuyDangKy_button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TenTaiKhoanDangKy_text)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TenDangNhapDangKy_text)
                    .addComponent(MatKhauDangKy_text)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );
        Sigin_panelLayout.setVerticalGroup(
            Sigin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sigin_panelLayout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenTaiKhoanDangKy_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenDangNhapDangKy_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MatKhauDangKy_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Sigin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HuyDangKy_button)
                    .addComponent(XacNhanDangKy_button))
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jPanel1.add(Sigin_panel);
        Sigin_panel.setBounds(0, 0, 360, 280);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/car.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 283);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DangNhap_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangNhap_buttonActionPerformed
        User taikhoan = new User();
        User_ToanCuc nguoidung = new User_ToanCuc();
        
        char[] pass = txtPassword.getPassword();
        String password = new String(pass);
        taikhoan.setPlayer_user(txtUsername.getText());
        taikhoan.setPlayer_pass(password);
        if(txtUsername.getText().equals("Tên đăng nhập")&&password.equals("........")){
            JOptionPane.showConfirmDialog(this, "Không được để trống tên đăng nhập và mật khẩu");
        }
        else if(txtUsername.getText().equals("Tên đăng nhập")){
            JOptionPane.showConfirmDialog(this, "Không được để trống tên đăng nhập");
        }
        else if(password.equals("........")){
            JOptionPane.showConfirmDialog(this, "Không được để trống mật khẩu");
        }
        else if(UserDAO.getInstance().selectById(taikhoan).getPlayer_pass().equals("0")){
            JOptionPane.showConfirmDialog(this, "Đăng nhập thất bại");
        }
        else if(taikhoan.getPlayer_user().equals(UserDAO.getInstance().selectById(taikhoan).getPlayer_user()) &&
            taikhoan.getPlayer_pass().equals(UserDAO.getInstance().selectById(taikhoan).getPlayer_pass())){
            nguoidung.setPlayer_user(UserDAO.getInstance().selectById(taikhoan).getPlayer_user());
            nguoidung.setPlayer_name(UserDAO.getInstance().selectById(taikhoan).getPlayer_name());
            nguoidung.setPlayer_pass(UserDAO.getInstance().selectById(taikhoan).getPlayer_pass());
            nguoidung.setPlayer_point(UserDAO.getInstance().selectById(taikhoan).getPlayer_point());
            this.dispose();
            new Controller_Login();
        }
        else{
            JOptionPane.showConfirmDialog(this, "Đăng nhập thất bại");
        }
    }//GEN-LAST:event_DangNhap_buttonActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if (txtUsername.getText().equals("Tên đăng nhập"))
        txtUsername.setText("");
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if(txtUsername.getText().equals("")){
            txtUsername.setText("Tên đăng nhập");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
      if(txtPassword.getText().equals("........"))
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if (txtPassword.getText().equals(""))
        txtPassword.setText("........");
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed

    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped

    }//GEN-LAST:event_txtPasswordKeyTyped

    private void DangKy_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangKy_buttonActionPerformed
        Login_panel.setVisible(false);
        Sigin_panel.setVisible(true);
    }//GEN-LAST:event_DangKy_buttonActionPerformed

    private void XacNhanDangKy_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XacNhanDangKy_buttonActionPerformed
        User TaiKhoan = new User();
        TaiKhoan.setPlayer_user(TenDangNhapDangKy_text.getText());
        TaiKhoan.setPlayer_name(TenTaiKhoanDangKy_text.getText());
        TaiKhoan.setPlayer_pass(MatKhauDangKy_text.getText());
        if(TaiKhoan.getPlayer_name().equals("") || TaiKhoan.getPlayer_user().equals("")
                || TaiKhoan.getPlayer_pass().equals("")){
            JOptionPane.showConfirmDialog(this, "Vui lòng điền đầy đủ thông tin");
        }
        else if(TaiKhoan.getPlayer_pass().length()<6){
            JOptionPane.showConfirmDialog(this, "Mật khẩu tối thiểu phải 6 kí tự");
        }
        else if(UserDAO.getInstance().selectById(TaiKhoan).getPlayer_user().equals("0")){
            UserDAO.getInstance().insert(TaiKhoan);
            JOptionPane.showConfirmDialog(this, "Đăng ký thành công");
            Sigin_panel.setVisible(false);
            Login_panel.setVisible(true);
        }else{
            JOptionPane.showConfirmDialog(this, "Tài khoản đã tồn tại");
            
        }
    }//GEN-LAST:event_XacNhanDangKy_buttonActionPerformed

    private void HuyDangKy_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyDangKy_buttonActionPerformed
        Sigin_panel.setVisible(false);
        Login_panel.setVisible(true);
    }//GEN-LAST:event_HuyDangKy_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangKy_button;
    private javax.swing.JButton DangNhap_button;
    private javax.swing.JButton HuyDangKy_button;
    private javax.swing.JPanel Login_panel;
    private javax.swing.JTextField MatKhauDangKy_text;
    private javax.swing.JPanel Sigin_panel;
    private javax.swing.JTextField TenDangNhapDangKy_text;
    private javax.swing.JTextField TenTaiKhoanDangKy_text;
    private javax.swing.JButton XacNhanDangKy_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
