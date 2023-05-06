package entity;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import mapgame.GamePanel;

public class Player extends Entity {
    GamePanel gp;
    public Player(GamePanel gp){
        this.gp=gp; 
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
    }
    public void getPlayerImage(){
        try{
            nv=ImageIO.read(getClass().getResourceAsStream("boy_down_1.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        Random rd= new Random();
        if(rd.nextBoolean()){
            x+=speed;
        }
        else{
            x-=speed;
        }
        if(rd.nextBoolean()){
            y+=speed;
        }
        else{
            y-=speed;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image =nv;
        g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
    }
}
