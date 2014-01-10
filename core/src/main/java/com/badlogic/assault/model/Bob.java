package com.badlogic.assault.model;

import com.badlogic.assault.model.data.StateBob;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bob {

//    static final float SPEED = 2f;	// unit per second
    public static final float SPEED = 4f;	// unit per second
    static final float JUMP_VELOCITY = 1f;
    public static final float SIZE = 0.5f; // half a unit
    private Vector2 position = new Vector2();
    private Vector2 acceleration = new Vector2();
    private Vector2 velocity = new Vector2();
    private Rectangle bounds = new Rectangle();
    private StateBob stateBob = StateBob.IDLE;
    private boolean facingLeft = true;
    private float       stateTime = 0;

    public Bob(Vector2 position) {
        this.position = position;
        this.bounds.height = SIZE;
        this.bounds.width = SIZE;
    }

    public void setState(StateBob newstateBob) {
        this.stateBob = newstateBob;
    }

    public void update(float delta) {
        stateTime += delta;
        position.add(velocity.cpy().scl(delta));
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public StateBob getStateBob() {
        return stateBob;
    }

    public void setStateBob(StateBob stateBob) {
        this.stateBob = stateBob;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }
}