package com.example.demo1;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;
import javafx.scene.transform.Rotate;

public class Car extends Entity {
    private PhysicsComponent physics;
    Car(){
        physics = getComponent(PhysicsComponent.class);
    }

}
