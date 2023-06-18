package com.example.demo1;
import static com.almasb.fxgl.core.math.FXGLMath.random;
import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;
import static com.almasb.fxgl.particle.ParticleEmitters.*;

import com.almasb.fxgl.app.FXGLApplication;
import com.almasb.fxgl.logging.Logger;
import com.almasb.fxgl.logging.LoggerConfig;
import com.almasb.fxgl.ui.Position;
import com.example.src1.DAO.UserDAO;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.GameScene;
import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.core.Inject;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.level.tiled.*;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputCapture;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.particle.Particle;
import com.almasb.fxgl.particle.ParticleComponent;
import com.almasb.fxgl.particle.ParticleEmitter;
import com.almasb.fxgl.physics.*;
import com.almasb.fxgl.physics.box2d.dynamics.BodyDef;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.ui.FXGLCheckBox;
//import com.src1.view.MainView;
import com.example.src1.Main.Main;
import com.example.src1.Model.User_ToanCuc;
import com.example.src1.controller.TinhDiem_controller;
import com.example.src1.view.MainView;
import com.example.src1.view.Play_panel;
import javafx.animation.Animation;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.example.src1.view.Play_panel.*;
import oracle.jdbc.logging.annotations.Log;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Game extends GameApplication{

    private UserDAO user;
    private String username=Play_panel.username;
    private final GameFactory geoWarsFactory=new GameFactory();
    private ArrayList<Entity> player;
    private  int soDat=Play_panel.xeDat;
    private final int mapChon=Play_panel.Mapchon;
    private int TongSo=Play_panel.TongTien;
    private int SoTien=Play_panel.sotien;
    public  ArrayList<String> Xe;
    public  ArrayList<String> Cnv;
    public static String Hinhanhcnv;
    public static String HinhanhXe;
    public static String HinhanhCnv;
    private int mauXe=Play_panel.mauXe;
    private int mauItem=Play_panel.mauItem;
   public static Boolean Win;
    public static int hasEnd=0;
    private String item;
    private String size=Play_panel.size;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    protected void initSettings(GameSettings settings){
        settings.setTitle("Geometry Wars");
        settings.setWidth(1920);
       settings.setHeight(1080);
//       settings.setFullScreenAllowed(true);
//       settings.setFullScreenFromStart(true);
    }
    public enum EntityType {
        PLAYER,
        FL,
        CONFETTI,
        START,
        FLAG,
        BIEN,
        LAVA,
        OBSTACLE
    }
    public void selectCNV(){
        Cnv=new ArrayList<>();
        if(mapChon==1) {
            Cnv.add("pol.png");
            Cnv.add("roadclose.png");
        }
        else if(mapChon==2){
            Cnv.add("puddle.png");
            Cnv.add("turtle.png");
        }
        else{
            Cnv.add("rock.png");
            Cnv.add("lava_puddle.png");
        }
    }

    public void SpawnCnv(int increment,int distance){
        Random random = new Random();
            int cnv=random.nextInt(2);
            Hinhanhcnv=Cnv.get(cnv);
            int lane = random.nextInt(3) + 1;
            int height=getAppHeight()/2-140;
            int width=getAppWidth()/2+900+increment;
            if(width>distance){
                return;
            }
            if (lane == 1) {
                Entity entity = spawn("cnv", width, height);
            }
            else if(lane==2){
                Entity entity=spawn("cnv",width,height+170);
            }
            else{
                Entity entity=spawn("cnv",width,height+340);
            }
        }
        public void ChuongNgaiVat(int distance){
            int increment=500;
           while(increment<distance) {
               SpawnCnv(increment,distance);
               increment += 500;
           }
        }
public void FireParticle(Entity entity){
        ParticleEmitter emitter=newFireEmitter(100);
        emitter.setSourceImage(getAssetLoader().loadTexture(item));
        emitter.setStartColor(Color.GREEN);
        emitter.setEndColor(Color.WHITE);
        emitter.setBlendMode(BlendMode.SRC_OVER);
        emitter.setSpawnPointFunction((i)->new Point2D(-25,2));
        emitter.setEmissionRate(0.5);
    emitter.setExpireFunction(i -> Duration.seconds(random(2, 5)));
        entity.addComponent(new ParticleComponent(emitter));
}
    public void Start(){
        Entity start =spawn("start",getAppWidth()/2+900,getAppHeight()/2-120);
        getGameWorld().addEntity(start);
        getGameTimer().runOnceAfter(()->{
            start.removeFromWorld();
            for(int i=0;i<player.size();i++){
                FireParticle(player.get(i));
            }
        },Duration.seconds(6));
    }
    public void BienTexture(){
        int y=0;
        for(int i=0;i<50;i++) {
            Entity bien = spawn("bien", getAppWidth() / 2-350 +y, getAppHeight() / 2+20 );
            getGameWorld().addEntity(bien);
            y+=300;
        }
    }
    public void lavaTexture(){
        int y=0;
        for(int i=0;i<50;i++) {
            Entity bien = spawn("lava", getAppWidth() / 2-400 +y, getAppHeight()/2+350 );
            getGameWorld().addEntity(bien);
            y+=300;
        }
    }
    public void selectMap(String size){
        com.almasb.fxgl.entity.level.Level level;
        if(size=="Nhỏ") {
            if (mapChon == 1) {
                level= FXGL.setLevelFromMap("map1_small.tmx");
                ChuongNgaiVat(level.getWidth()-700);
            } else if (mapChon == 2) {
                level= FXGL.setLevelFromMap("map2_small.tmx");
                ChuongNgaiVat(level.getWidth()-700);
                BienTexture();
            } else {
                level= FXGL.setLevelFromMap("map3_small.tmx");
                ChuongNgaiVat(level.getWidth()-700);
                lavaTexture();
            }
        }
        else if(size=="Trung bình"){
            if (mapChon == 1) {
                level= FXGL.setLevelFromMap("map1_medium.tmx");
                ChuongNgaiVat(level.getWidth()-700);
            } else if (mapChon == 2) {
                level= FXGL.setLevelFromMap("map2_medium.tmx");
                ChuongNgaiVat(level.getWidth()-700);
                BienTexture();
            } else {
                level= FXGL.setLevelFromMap("map3_medium.tmx");
                ChuongNgaiVat(level.getWidth()-700);
                lavaTexture();
            }
        }
        else{
            if (mapChon == 1) {
                level= setLevelFromMap("map1_large.tmx");
                ChuongNgaiVat(level.getWidth()-700);
            } else if (mapChon == 2) {
                level=   FXGL.setLevelFromMap("map2-large.tmx");
                ChuongNgaiVat(level.getWidth()-700);
                BienTexture();
            } else {
                level=  FXGL.setLevelFromMap("map3_large.tmx");
                ChuongNgaiVat(level.getWidth()-700);
                lavaTexture();
            }
        }
    }
    public void selectItem(){
        if(mauItem==1){
           item="fire.png";
        }
        else if(mauItem==2){
            item="greenfire.gif";
        }
        else {
            item="water.png";

        }
    }
    public void selectXe(){
        Xe=new ArrayList<>();
        if(mauXe==1){
            Xe.add("anh1.png");
            Xe.add("anh2.png");
            Xe.add("anh3.png");
        }
        else if(mauXe==2){
            Xe.add("car1.png");
            Xe.add("car2.png");
            Xe.add("car3.png");
        }
        else if(mauXe==3){
            Xe.add("f1_1.png");
            Xe.add("f1_2.png");
            Xe.add("f1_3.png");
        }
    }
    @Override
    protected void initGame(){
        getGameWorld().addEntityFactory(geoWarsFactory);
        user=new UserDAO();
        selectXe();
        selectItem();
        selectCNV();
        selectMap(size);
      Start();
        Win=false;
        player=new ArrayList<>();
        int y=0;
        for(int i=0;i<3;i++) {
            Entity entity=new Entity();
            HinhanhXe=Xe.get(0);
            entity= spawn("player", getAppWidth()/2+600, getAppHeight()/2-140 + y);
            Xe.remove(0);
            entity.getComponent(playerComponent.class).sohieu=i;
            player.add(entity);
            getGameWorld().addEntities(entity);
            y=y+170;
        }
        if(soDat==1) {
            getGameScene().getViewport().bindToEntity(player.get(0), getAppWidth() / 2, getAppHeight() / 2-115);
        }
        else if(soDat==2){
            getGameScene().getViewport().bindToEntity(player.get(1), getAppWidth() / 2, getAppHeight() / 2);
        }
        else if (soDat==3){
            getGameScene().getViewport().bindToEntity(player.get(2), getAppWidth() / 2, getAppHeight() / 2+200);
        }
}

    @Override
    protected void initPhysics() {
        getPhysicsWorld().setGravity(0,0);
       for(int i=0;i<3;i++){
           getPhysicsWorld().onEntityAdded(player.get(i));
       }
       getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER,EntityType.OBSTACLE) {
           @Override
           protected void onCollisionBegin(Entity a, Entity b) {
               b.removeComponent(PhysicsComponent.class);
               b.removeFromWorld();
           }
           @Override
           protected void onCollisionEnd(Entity a,Entity b){
               Random random=new Random();
               float acclerationInput =  0.7f + random.nextFloat() * 0.9f;;
               int accelerationFactor = random.nextInt(101) + 50;
               a.getComponent(playerComponent.class).up(acclerationInput,accelerationFactor);
           }
       });
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER,EntityType.FL) {

            @Override
            protected void onCollisionBegin(Entity a, Entity b) {
                int ketqua;
                a.removeComponent(PhysicsComponent.class);
                getGameTimer().runOnceAfter(()->{
                    a.removeComponent(ParticleComponent.class);
                },Duration.seconds(2));

                Entity entity1=spawn("flag",a.getX()-150,a.getY()-250);
                getGameWorld().addEntity(entity1);
                hasEnd++;
                if(soDat-1==a.getComponent(playerComponent.class).sohieu && hasEnd==1){
                    Win=true;
                }
                if(hasEnd==3){
                    b.removeFromWorld();
                    getPhysicsWorld().setGravity(50,100);
                    getGameTimer().runAtInterval(()->{
                        double y1=400;
                        double y2=600;
                        for(int i=1;i<100;i++) {
                            if(i%2==0) {
                                Entity entity = spawn("confetti", getGameScene().getViewport().getX() / 2 + y1, getGameScene().getViewport().getY()+y2);
                                getGameWorld().addEntity(entity);
                                getPhysicsWorld().onEntityAdded(entity);
                                y1 = y1 + 300;
                            }
                            else{
                                Entity entity = spawn("confetti", getGameScene().getViewport().getX() / 2 + y1, getGameScene().getViewport().getY());
                                getGameWorld().addEntity(entity);
                                getPhysicsWorld().onEntityAdded(entity);
                                y1 = y1 + 300   ;
                            }
                        }
                    },Duration.seconds(0.5),10);

                    if(Win==true){
                        ketqua=1;
                        TongSo+=SoTien;
                        Play_panel.TongTien+=SoTien;
                        System.out.println("xe ban dat thang "+ TongSo);
                    }else if(soDat==a.getComponent(playerComponent.class).sohieu){
                        ketqua=2;
                        TongSo+=SoTien;
                        Play_panel.TongTien+=SoTien;
                        System.out.println("xe ban dat thang "+ TongSo);
                    }
                    else{
                        ketqua=3;
                        TongSo -= SoTien;
                        Play_panel.TongTien-=SoTien;
                        System.out.println("Tong so tien "+TongSo);
                    }
                    user.updatePoint(TongSo, username);


                    getGameTimer().runOnceAfter(()->{
                        Play_panel.frame.dispose();
                        GameApplication.embeddedShutdown();

                        new TinhDiem_controller(ketqua);
                        ConsoleHandler consoleHandler = new ConsoleHandler();
                        consoleHandler.setLevel(java.util.logging.Level.INFO);
                    },Duration.seconds(7));

                }

            }
        });

    }
    @Override
    public void onUpdate(double tpf) {

        }

    }



