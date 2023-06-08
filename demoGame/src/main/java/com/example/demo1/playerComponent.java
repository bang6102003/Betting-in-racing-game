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
    private TransformComponent transform;
    private boolean canMove = true;

    public float brakeFactor=20.0f;
  public float driftfactor=0.95f;
    public float turnFactor=10.0f;
    static float accelerationInput=0;
    static float steeringInput=0;
    float rotationAngle=10;
    public int sohieu;
    public static float increaseFactor=0.01f;

    playerComponent(PhysicsComponent physics){

        this.physics = physics;
    }
    public void up(float x,float y){

            accelerationInput=x;
            ApplyEngineForce(x,y);



    }
    public void stop(){
       physics.setOnPhysicsInitialized(()->{
           physics.setLinearVelocity(0,0);
       });
    }

    // Update the entity's position in the game loop
    @Override
    public void onUpdate(double tpf) {
//        if(accelerationInput > 1){
//            accelerationInput=1;
//        }
//       accelerationInput+=0.1f;
    }
    public void ApplyEngineForce(float accelerationInput,float accelerationFactor){
        Vec2 engineForce=(new Vec2(getUpVector()).mul(accelerationInput)).mul(accelerationFactor);
        physics.setLinearVelocity(new Point2D(engineForce.x,engineForce.y));

    }
//    public void ApplyEngineForceBackward(){
//        Vec2 engineForce=(new Vec2(getUpVector()).mul(accelerationInput)).mul(accelerationFactor);
//        physics.setLinearVelocity(new Point2D(-engineForce.x,-engineForce.y));
//    }
//
//    public void ApplySteeringForce(){
//        float minSpeed=(float) physics.getLinearVelocity().magnitude()/8;
//        minSpeed=(float) Math.min(1.0, Math.max(0.0, minSpeed));
//        rotationAngle-=steeringInput*turnFactor*minSpeed;
//        physics.setAngularVelocity(rotationAngle);
//    }

    public Point2D getUpVector() {
        // Get the rotation of the entity in degrees
        double rotation = entity.getRotation();
        // Create a vector that points in the upward direction (0 degrees)
        Point2D up = new Point2D(1, 0);
        // Rotate the vector by the entity's rotation
        Rotate r = new Rotate(rotation);
        Point2D rotatedUp = r.transform(up);

        // Normalize the vector to get the direction without the magnitude
        return rotatedUp.normalize();

    }
//    public void KillVector(){
//        Point2D forwardV=physics.getLinearVelocity();
//        double rightV=physics.getLinearVelocity().getX();
//        physics.setLinearVelocity(forwardV.add(rightV*driftfactor,0));
//    }
}
