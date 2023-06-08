package com.example.demo1;
import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;
import static com.almasb.fxgl.particle.ParticleEmitters.*;

import com.almasb.fxgl.logging.Logger;
import com.almasb.fxgl.logging.LoggerConfig;
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
import com.almasb.fxgl.entity.level.Level;
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

public class GeoWarsApp extends GameApplication{

    private UserDAO user;
    private String username=Play_panel.username;
    private GeoWarsFactory geoWarsFactory;
    private ArrayList<Entity> player;
    private  int soDat=Play_panel.xeDat;
    private final int mapChon=Play_panel.Mapchon;
    private int TongSo=Play_panel.TongTien;
    private int SoTien=Play_panel.sotien;
    public  ArrayList<String> Xe;
    public static String HinhanhXe;
    private int mauXe=Play_panel.mauXe;
   public static Boolean Win;
    public static int hasEnd=0;
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
        VOCANO
    }

public void FireParticle(Entity entity){
        ParticleEmitter emitter=newFireEmitter(100);
        emitter.setSourceImage(getAssetLoader().loadTexture("fire.png"));
        emitter.setStartColor(Color.YELLOW);
        emitter.setEndColor(Color.RED);
        emitter.setSpawnPointFunction((i)->new Point2D(-25,2));
        emitter.setEmissionRate(0.5);
        entity.addComponent(new ParticleComponent(emitter));
}
    public void Start(){
        Entity start =spawn("start",getAppWidth()/2+900,getAppHeight()/2-120);
        getGameWorld().addEntity(start);
        getGameTimer().runOnceAfter(()->{
            start.removeFromWorld();
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
            Entity bien = spawn("lava", getAppWidth() / 2-400 +y, getAppHeight()/2+340 );
            getGameWorld().addEntity(bien);
            y+=300;
        }
    }
    public void selectMap(){
        if(mapChon==1){
            FXGL.setLevelFromMap("map1.tmx");
        }
        else if(mapChon==2){
            FXGL.setLevelFromMap("map2.tmx");
            BienTexture();
        }
        else {
            FXGL.setLevelFromMap("map3.tmx");
            lavaTexture();
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
        geoWarsFactory=new GeoWarsFactory();
        getGameWorld().addEntityFactory(geoWarsFactory);
        user=new UserDAO();
        selectMap();
        selectXe();
        System.out.println(Xe);
      Start();
        Win=false;
        player=new ArrayList<>();
        int y=10;
        for(int i=0;i<3;i++) {
            Entity entity=new Entity();
            HinhanhXe=Xe.get(0);
            entity= spawn("player", getAppWidth()/2+600, getAppHeight()/2-150 + y);
            Xe.remove(0);
//            FireParticle(entity);
            entity.getComponent(playerComponent.class).sohieu=i;
            player.add(entity);
            getGameWorld().addEntities(entity);
            y=y+170;
        }
        getGameScene().getViewport().bindToEntity(player.get(1),getAppWidth()/2,getAppHeight()/2);

}

    @Override
    protected void initPhysics() {
        getPhysicsWorld().setGravity(0,0);
       for(int i=0;i<3;i++){
           getPhysicsWorld().onEntityAdded(player.get(i));
       }
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER,EntityType.FL) {

            @Override
            protected void onCollisionBegin(Entity a, Entity b) {

                int ketqua;
                a.removeComponent(PhysicsComponent.class);
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
                    }
                    else{
                        ketqua=3;
                        TongSo -= SoTien;
                        Play_panel.TongTien-=SoTien;
                        System.out.println("Tong so tien "+TongSo);
                    }
                    System.out.println(TongSo);
                    user.updatePoint(TongSo, username);
                    Play_panel.frame.dispose();
                    GameApplication.embeddedShutdown();
                    new TinhDiem_controller(ketqua);
                }

            }
        });

    }
    @Override
    public void onUpdate(double tpf) {

        }

    }



