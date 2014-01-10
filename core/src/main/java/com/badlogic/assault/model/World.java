package com.badlogic.assault.model;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Block> blocks = new ArrayList<Block>();
    private Bob bob;

    public Bob getBob() {
        return bob;
    }

    public World() {
        createDemoWorld();
    }

    private void createDemoWorld() {
        bob = new Bob(new Vector2(7, 2));

        for (int i = 0; i < 10; i++) {
            getBlocks().add(new Block(new Vector2(i, 0)));
            getBlocks().add(new Block(new Vector2(i, 6)));
            if (i > 2) {
                getBlocks().add(new Block(new Vector2(i, 1)));
            }
        }
        getBlocks().add(new Block(new Vector2(9, 2)));
        getBlocks().add(new Block(new Vector2(9, 3)));
        getBlocks().add(new Block(new Vector2(9, 4)));
        getBlocks().add(new Block(new Vector2(9, 5)));

        getBlocks().add(new Block(new Vector2(6, 3)));
        getBlocks().add(new Block(new Vector2(6, 4)));
        getBlocks().add(new Block(new Vector2(6, 5)));
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}