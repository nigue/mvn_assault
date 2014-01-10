package com.badlogic.assault.controller;

import com.badlogic.assault.controller.data.KeysBobController;
import com.badlogic.assault.model.Bob;
import com.badlogic.assault.model.World;
import com.badlogic.assault.model.data.StateBob;
import java.util.HashMap;
import java.util.Map;

public class BobController {

    private static final long LONG_JUMP_PRESS = 150l;
    private static final float ACCELERATION = 20f;
    private static final float GRAVITY = -20f;
    private static final float MAX_JUMP_SPEED = 7f;
    private static final float DAMP = 0.90f;
    private static final float MAX_VEL = 4f;
    // these are temporary
    private static final float WIDTH = 10f;
    private World world;
    private Bob bob;
    private long jumpPressedTime;
    private boolean jumpingPressed;
    static Map<KeysBobController, Boolean> keys = new HashMap<KeysBobController, Boolean>();

    static {
        keys.put(KeysBobController.LEFT, false);
        keys.put(KeysBobController.RIGHT, false);
        keys.put(KeysBobController.JUMP, false);
        keys.put(KeysBobController.FIRE, false);
    }

    ;

    public BobController(World world) {
        this.world = world;
        this.bob = world.getBob();
    }

    public void jumpReleased() {
        keys.get(keys.put(KeysBobController.JUMP, false));
        jumpingPressed = false;
    }

    // ** Key presses and touches **************** //
    public void leftPressed() {
        keys.get(keys.put(KeysBobController.LEFT, true));
    }

    public void rightPressed() {
        keys.get(keys.put(KeysBobController.RIGHT, true));
    }

    public void jumpPressed() {
        keys.get(keys.put(KeysBobController.JUMP, true));
    }

    public void firePressed() {
        keys.get(keys.put(KeysBobController.FIRE, false));
    }

    public void leftReleased() {
        keys.get(keys.put(KeysBobController.LEFT, false));
    }

    public void rightReleased() {
        keys.get(keys.put(KeysBobController.RIGHT, false));
    }

    public void fireReleased() {
        keys.get(keys.put(KeysBobController.FIRE, false));
    }

    /**
     * The main update method *
     */
    public void update(float delta) {
        processInput();

        bob.getAcceleration().y = GRAVITY;
        bob.getAcceleration().mul(delta);
        bob.getVelocity().add(bob.getAcceleration().x, bob.getAcceleration().y);
        if (bob.getAcceleration().x == 0) {
            bob.getVelocity().x *= DAMP;
        }
        if (bob.getVelocity().x > MAX_VEL) {
            bob.getVelocity().x = MAX_VEL;
        }
        if (bob.getVelocity().x < -MAX_VEL) {
            bob.getVelocity().x = -MAX_VEL;
        }

        bob.update(delta);
        if (bob.getPosition().y < 0) {
            bob.getPosition().y = 0f;
            bob.setPosition(bob.getPosition());
            if (bob.getStateBob().equals(StateBob.JUMPING)) {
                bob.setState(StateBob.IDLE);
            }
        }
        if (bob.getPosition().x < 0) {
            bob.getPosition().x = 0;
            bob.setPosition(bob.getPosition());
            if (!bob.getStateBob().equals(StateBob.JUMPING)) {
                bob.setState(StateBob.IDLE);
            }
        }
        if (bob.getPosition().x > WIDTH - bob.getBounds().width) {
            bob.getPosition().x = WIDTH - bob.getBounds().width;
            bob.setPosition(bob.getPosition());
            if (!bob.getStateBob().equals(StateBob.JUMPING)) {
                bob.setState(StateBob.IDLE);
            }
        }
    }

    /**
     * Change Bob's state and parameters based on input controls *
     */
    private boolean processInput() {
//        if (keys.get(KeysBobController.LEFT)) {
//            // left is pressed
//            bob.setFacingLeft(true);
//            bob.setState(StateBob.WALKING);
//            bob.getVelocity().x = -Bob.SPEED;
//        }
//        if (keys.get(KeysBobController.RIGHT)) {
//            // left is pressed
//            bob.setFacingLeft(false);
//            bob.setState(StateBob.WALKING);
//            bob.getVelocity().x = Bob.SPEED;
//        }
//        // need to check if both or none direction are pressed, then Bob is idle
//        if ((keys.get(KeysBobController.LEFT) && keys.get(KeysBobController.RIGHT))
//                || (!keys.get(KeysBobController.LEFT) && !(keys.get(KeysBobController.RIGHT)))) {
//            bob.setState(StateBob.IDLE);
//            // acceleration is 0 on the x
//            bob.getAcceleration().x = 0;
//            // horizontal speed is 0
//            bob.getVelocity().x = 0;
//        }

        if (keys.get(KeysBobController.JUMP)) {
            if (!bob.getStateBob().equals(StateBob.JUMPING)) {
                jumpingPressed = true;
                jumpPressedTime = System.currentTimeMillis();
                bob.setState(StateBob.JUMPING);
                bob.getVelocity().y = MAX_JUMP_SPEED;
            } else {
                if (jumpingPressed && ((System.currentTimeMillis() - jumpPressedTime) >= LONG_JUMP_PRESS)) {
                    jumpingPressed = false;
                } else {
                    if (jumpingPressed) {
                        bob.getVelocity().y = MAX_JUMP_SPEED;
                    }
                }
            }
        }
        if (keys.get(KeysBobController.LEFT)) {
            // left is pressed
            bob.setFacingLeft(true);
            if (!bob.getStateBob().equals(StateBob.JUMPING)) {
                bob.setState(StateBob.WALKING);
            }
            bob.getAcceleration().x = -ACCELERATION;
        } else if (keys.get(KeysBobController.RIGHT)) {
            // left is pressed
            bob.setFacingLeft(false);
            if (!bob.getStateBob().equals(StateBob.JUMPING)) {
                bob.setState(StateBob.WALKING);
            }
            bob.getAcceleration().x = ACCELERATION;
        } else {
            if (!bob.getStateBob().equals(StateBob.JUMPING)) {
                bob.setState(StateBob.IDLE);
            }
            bob.getAcceleration().x = 0;

        }
        return false;
    }
}
