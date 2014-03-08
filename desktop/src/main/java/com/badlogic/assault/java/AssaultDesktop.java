package com.badlogic.assault.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.badlogic.assault.core.Assault;

public class AssaultDesktop {

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.useGL30 = true;
        config.title = "Star Assault";
//        config.width = 480;
//        config.height = 320;
//        config.fullscreen = false;
        config.width = 1366;
        config.height = 768;
        config.fullscreen = true;
        new LwjglApplication(new Assault(), config);
    }
}
