package com.badlogic.assault.controller.data;

public enum KeysBobController {

    LEFT("left"),
    RIGHT("Right"),
    JUMP("Jump"),
    FIRE("Fire");
    private String keysBobController;

    private KeysBobController(String keysBobController) {
        this.keysBobController = keysBobController;
    }

    public String getKeysBobController() {
        return keysBobController;
    }
}
