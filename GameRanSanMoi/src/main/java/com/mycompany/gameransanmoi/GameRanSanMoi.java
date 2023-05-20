/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gameransanmoi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author trung
 */
public class GameRanSanMoi extends JFrame implements ActionListener, KeyListener {

    // Biến kiểm tra kết thúc.
    boolean ending = false;
    
    // Kích thức tối đa của tọa độ X, Y. 
    int maxXY = 100;
    
    // Kích thước cửa sổ chương trình.
    int width = 15, length = 30;
    
    int start = 0;
    
    // Màu lần lượt của nền, thân rắn, đầu rắn, thức ăn.
    Color background_cl[] = {Color.gray, Color.LIGHT_GRAY, Color.darkGray, Color.RED};
    
    int convertX[] = {-1, 0, 1, 0};
    int convertY[] = {0, 1, 0, -1};
    
    // Tốc độ di chuyển của rắn.
    int speed = 70;
    
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

    public GameRanSanMoi(String s) {
        super(s);
        container = init();
        timer = new Timer(speed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runSnake(direction);
            }
        });
    }

    public Container init() {
        Container cn = this.getContentPane();
        pn_map = new JPanel();
        pn_map.setLayout(new GridLayout(width, length));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j] = new JButton();
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
    public void runSnake(int k) {
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
            ending = true;
            return;
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

    public static void main(String[] args) {
        new GameRanSanMoi("Rắn Săn Mồi");
    }
}
