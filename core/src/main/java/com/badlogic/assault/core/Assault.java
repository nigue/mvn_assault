package com.badlogic.assault.core;

import com.badlogic.assault.screens.GameScreen;
import com.badlogic.gdx.Game;

public class Assault extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
