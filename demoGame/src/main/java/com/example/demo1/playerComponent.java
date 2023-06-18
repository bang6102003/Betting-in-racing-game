package com.example.demo1;
import com.almasb.fxgl.core.math.Vec2;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.almasb.fxgl.particle.ParticleEmitter;
import javafx.geometry.Point2D;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.scene.transform.Rotate;

public class playerComponent extends Component{
    private PhysicsComponent physics;


    static float accelerationInput=0;

    public int sohieu;


    playerComponent(PhysicsComponent physics){

        this.physics = physics;
    }
    public void up(float x,float y){
            accelerationInput=x;
            ApplyEngineForce(x,y);
    }

    public void ApplyEngineForce(float accelerationInput,float accelerationFactor) {
        Vec2 engineForce = (new Vec2(getUpVector()).mul(accelerationInput)).mul(accelerationFactor);
        physics.setLinearVelocity(new Point2D(engineForce.x, engineForce.y));
    }
    public Point2D getUpVector() {
        double rotation = entity.getRotation();
        Point2D up = new Point2D(1, 0);
        Rotate r = new Rotate(rotation);
        Point2D rotatedUp = r.transform(up);
        return rotatedUp.normalize();

    }
}
