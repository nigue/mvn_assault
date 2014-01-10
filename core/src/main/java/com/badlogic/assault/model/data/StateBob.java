package com.badlogic.assault.model.data;

public enum StateBob {

    IDLE("Idle"),
    WALKING("Walking"),
    JUMPING("Jumping"),
    DYING("Dying");
    private String stateBob;

    private StateBob(String stateBob) {
        this.stateBob = stateBob;
    }

    public String getStateBob() {
        return stateBob;
    }
}
