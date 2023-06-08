package com.example.demo1;
import static com.almasb.fxgl.dsl.FXGL.*;
import static com.example.demo1.GeoWarsApp.HinhanhXe;

//import static main.java.com.example.demo.GeoWarsApp.Win;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import com.almasb.fxgl.texture.Texture;
//import main.java.com.example.demo.GeoWarsApp.EntityType;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.example.src1.view.Play_panel;
import javafx.scene.image.Image;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;


public class GeoWarsFactory implements EntityFactory {
    private int mauXe= Play_panel.mauXe;
    @Spawns("player")
    public Entity newPlayer1(SpawnData data) {
        Texture texture = getAssetLoader().loadTexture(HinhanhXe);
        texture.setScaleX(1.5);
        texture.setScaleY(1.5);
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        playerComponent component=new playerComponent(physics);
        return entityBuilder()
                .from(data)
                .type(GeoWarsApp.EntityType.PLAYER)
                .with(physics)
                .with(component)
              .with(new MyFunctionComponent(()->{
                  getGameTimer().runOnceAfter(()->{
                      getGameTimer().runAtInterval(()->{
                          Random random=new Random();
                          float acclerationInput =  0.7f + random.nextFloat() * 0.9f;;
                          int accelerationFactor = random.nextInt(301) + 300;
                          component.up(acclerationInput,accelerationFactor);
                      }, Duration.seconds(1));
                  },Duration.seconds(5));
              }))
                .viewWithBBox(texture)
                .collidable()
                .build();
    }
    @Spawns("bien")
    public Entity newBien(SpawnData data){
        Texture texture=getAssetLoader().loadTexture("beach.gif");
        return  entityBuilder()
                .from(data)
                .type(GeoWarsApp.EntityType.BIEN)
                .viewWithBBox(texture)
                .build();
    }
    @Spawns("lava")
    public Entity newLava(SpawnData data){
        Texture texture=getAssetLoader().loadTexture("lava.gif");
        return  entityBuilder()
                .from(data)
                .type(GeoWarsApp.EntityType.LAVA)
                .viewWithBBox(texture)
                .build();
    }
    @Spawns("vocano")
    public Entity newVocano(SpawnData data){
        Texture texture=getAssetLoader().loadTexture("vocalno.gif");
        return  entityBuilder()
                .from(data)
                .type(GeoWarsApp.EntityType.LAVA)
                .viewWithBBox(texture)
                .build();
    }
    @Spawns("finishLine")
    public Entity newFL(SpawnData data){
        PhysicsComponent physics=new PhysicsComponent();
        return entityBuilder()
                .type(GeoWarsApp.EntityType.FL)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(92.00,548.00)))
                .with(physics)
                .collidable()
                .build();
    }
    @Spawns("confetti")
    public Entity newConfetti(SpawnData data){
//        Component component=new Component() {
//            int x=30;
//            @Override
//            public void onUpdate(double tpf) {
////                entity.translateY(10);
//                entity.rotationZProperty().setValue(x);
//                x+=5;
//            }
//        };
//        PhysicsComponent physicsComponent=new PhysicsComponent();
//        physicsComponent.setBodyType(BodyType.DYNAMIC);
//        Rectangle rectangle=new Rectangle(random.nextDouble()*80,random.nextDouble()*70);
//        rectangle.setFill(getRandomColor());
        Texture texture=getAssetLoader().loadTexture("diwali-sparkles-stars.gif");
        return entityBuilder()
                .from(data)
                .type(GeoWarsApp.EntityType.CONFETTI)
                .viewWithBBox(texture)
//                .viewWithBBox(rectangle)
//                .with(physicsComponent)
//                .with(component)
                .build();
    }
    @Spawns("start")
    public Entity newStart(SpawnData data) {
        Texture texture= getAssetLoader().loadTexture("start.gif");
        texture.setScaleX(1.5);
        texture.setScaleY(1.5);
                return entityBuilder()
                        .from(data)
                        .type(GeoWarsApp.EntityType.START)
                        .viewWithBBox(texture)
                        .build();
    }
    @Spawns("flag")
    public Entity newFlag(SpawnData data) {
        Texture texture = getAssetLoader().loadTexture("gif-flag.gif");
        texture.setScaleX(0.1);
        texture.setScaleY(0.1);
        return entityBuilder()
                .from(data)
                .type(GeoWarsApp.EntityType.FLAG)
                .viewWithBBox(texture)
                .build();
    }

}