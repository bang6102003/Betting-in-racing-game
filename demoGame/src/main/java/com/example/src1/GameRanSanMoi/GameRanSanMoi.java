/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.example.src1.GameRanSanMoi;

import com.example.src1.Model.User;
import com.example.src1.Model.User_ToanCuc;
import com.example.src1.controller.Controller_Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.example.src1.DAO.UserDAO;
import com.example.src1.view.Account_Panel;
import com.example.src1.view.Play_panel;

/**
 *
 * @author trung
 */
public class GameRanSanMoi extends JFrame implements ActionListener, KeyListener, WindowListener{

    // Biến kiểm tra kết thúc.
   public static boolean ending = false;
    
    // Kích thức tối đa của tọa độ X, Y. 
    int maxXY = 100;
    
    // Kích thước cửa sổ chương trình.
    int width = 15, length = 30;
    
    int start = 0;
    
    // Màu lần lượt của nền, thân rắn, đầu rắn, thức ăn.
    Color background_cl[] = {Color.WHITE, Color.RED, Color.GREEN, Color.RED};
    
    int convertX[] = {-1, 0, 1, 0};
    int convertY[] = {0, 1, 0, -1};
    
    // Tốc độ di chuyển của rắn.
    int speed = 100;
    
    private JButton map[][] = new JButton[maxXY][maxXY];
        
    // Biến phân biệt khoảng trống(0), thân rắn(1), đầu rắn(2), thức ăn(3).
    private int ViTri[][] = new int[maxXY][maxXY];
    
    // Tọa độ X của rắn.
    private int xSnake[] = new int[maxXY * maxXY];
       
    // Tọa độ Y của rắn.
    private int ySnake[] = new int[maxXY * maxXY];
    
    // Tọa độ của thức ăn.
    private int xFood, yFood;
    
    // Độ dài của rắn.
    private int sizeSnake;
    
    // Hướng di chuyển so với màn hình (1: LÊN, 2: PHẢI, 3: XUỐNG, 4: TRÁI)
    private int direction = 2;
    
    // Hiển thị thông tin về điểm.
    private JLabel score;
    private JLabel Diem;
    
    private JPanel pn_map, pn_ThongTin;
    Container container;
    Timer timer;
    UserDAO user2;
    public  int TongTien= User_ToanCuc.getPlayer_point();
    public  String username=User_ToanCuc.getPlayer_user();
    public GameRanSanMoi(String s) {
        super(s);
        container = init();
        timer = new Timer(speed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int diem = runSnake(direction);
                User user = new User();
                User_ToanCuc user1 = new User_ToanCuc();
                user1.setPlayer_point(user1.getPlayer_point()+diem);

            }
        });
    }
    protected void paintBorder(Graphics g) {
        // Không làm gì để vô hiệu hóa việc vẽ border
    }
    public Container init() {
        user2=new UserDAO();
        Container cn = this.getContentPane();
        pn_map = new JPanel();
        pn_map.setBackground(Color.WHITE);
        pn_map.setLayout(new GridLayout(width, length,0,0));
        pn_map.paintAll(null);
//        pn_map.setOpaque(false);
        addWindowListener(this);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j] = new JButton();
                map[i][j].setBorderPainted(false);
                map[i][j].setOpaque(false);
                pn_map.add(map[i][j]);
                map[i][j].setActionCommand(i + " " + j);
                map[i][j].addActionListener(this);
                map[i][j].addKeyListener(this);
                map[i][j].setBorder(null);
                ViTri[i][j] = 0;
            }
        }

        pn_ThongTin = new JPanel();
        pn_ThongTin.setLayout(new FlowLayout());


        score = new JLabel("0");
        score.setFont(new Font("Arial", Font.BOLD , 20));
        score.setBackground(Color.white);

        Diem = new JLabel("Điểm: ");
        Diem.setFont(new Font("Arial", Font.BOLD , 20));
        Diem.setBackground(Color.white);

        pn_ThongTin.add(Diem);
        pn_ThongTin.add(score);

        ViTri[width / 2][length / 2 - 1] = 1;
        ViTri[width / 2][length / 2] = 1;
        ViTri[width / 2][length / 2 + 1] = 2;
        xSnake[0] = width / 2;
        ySnake[0] = length / 2 - 1;
        xSnake[1] = width / 2;
        ySnake[1] = length / 2;
        xSnake[2] = width / 2;
        ySnake[2] = length / 2 + 1;
        sizeSnake = 3;

        creatFood();
        updateColor();
        cn.add(pn_map);
        cn.add(pn_ThongTin, "South");
        this.setVisible(true);
        this.setSize(length * 30, width * 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        return cn;
    }

    public void updateColor() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j].setBackground(background_cl[ViTri[i][j]]);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    // Hàm cho rắn chạy.
    public int runSnake(int k) {
        ViTri[xSnake[sizeSnake - 1]][ySnake[sizeSnake - 1]] = 1;
        xSnake[sizeSnake] = xSnake[sizeSnake - 1] + convertX[k - 1];
        ySnake[sizeSnake] = ySnake[sizeSnake - 1] + convertY[k - 1];

        if (xSnake[sizeSnake] < 0) {
            xSnake[sizeSnake] = width - 1;
        }
        if (xSnake[sizeSnake] == width) {
            xSnake[sizeSnake] = 0;
        }
        if (ySnake[sizeSnake] < 0) {
            ySnake[sizeSnake] = length - 1;
        }
        if (ySnake[sizeSnake] == length) {
            ySnake[sizeSnake] = 0;
        }
        
        // Kết thúc.
        if (ViTri[xSnake[sizeSnake]][ySnake[sizeSnake]] == 1) {

            timer.stop();
            JOptionPane.showMessageDialog(null, "Kết thúc trò chơi với " + score.getText() + " điểm.");
            dispose();
            ending = true;
            int diem = Integer.parseInt(score.getText());
            user2.updatePoint(TongTien+diem,username);
            Account_Panel.SODU_TEXT.setText(String.valueOf(TongTien+diem));
            return diem;
        }
        
        ViTri[xSnake[start]][ySnake[start]] = 0;
        
        // Khi rắn ăn được thức ăn.
        if (xFood == xSnake[sizeSnake] && yFood == ySnake[sizeSnake]) {
            ViTri[xSnake[start]][ySnake[start]] = 1;
            start--;
            creatFood();
            score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
        }
        ViTri[xSnake[sizeSnake]][ySnake[sizeSnake]] = 2;
        start++;
        sizeSnake++;
        updateColor();
        for (int i = start; i < sizeSnake; i++) {
            xSnake[i - start] = xSnake[i];
            ySnake[i - start] = ySnake[i];
        }
        sizeSnake -= start;
        start = 0;
        return 0;
    }

    // Hàm tạo thức ăn.
    public void creatFood() {
        int k = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (ViTri[i][j] == 0) {
                    k++;
                }
            }
        }
        int h = (int) ((k - 1) * Math.random() + 1);
        k = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (ViTri[i][j] == 0) {
                    k++;
                    if (k == h) {
                        xFood = i;
                        yFood = j;
                        ViTri[i][j] = 3;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!ending) {
            // TODO Auto-generated method stub
            if (e.getKeyCode() == e.VK_UP && direction != 3) {
                direction = 1; // LÊN 
                timer.start();
            }
            if (e.getKeyCode() == e.VK_RIGHT && direction != 4) {
                direction = 2; // PHẢI
                timer.start();
            }
            if (e.getKeyCode() == e.VK_DOWN && direction != 1) {
                direction = 3; // XUỐNG
                timer.start();
            }
            if (e.getKeyCode() == e.VK_LEFT && direction != 2) {
                direction = 4; // TRÁI
                timer.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
    


    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         int option = JOptionPane.showConfirmDialog(this,
                        "Thoát sẽ không tính điểm", "Thông báo",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    
                    dispose();
                }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
//    
//    
//    public static void main(String[] args) {
//        new GameRanSanMoi("Rắn Săn Mồi");
//    }
}
