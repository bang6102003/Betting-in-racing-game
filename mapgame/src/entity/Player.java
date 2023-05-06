package entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

import mapgame.GamePanel;

public class Player extends Entity {
    GamePanel gp;
    public Player(GamePanel gp){
        this.gp=gp; 
        solidArea=new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x=200;
        y=200;
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
        // BotAI
         
        collisionOn=false;
        gp.cChecker.checkTile(this);
        if(collisionOn==false){
            // Moving of BotAI
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image =nv;
        g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
    }
}
