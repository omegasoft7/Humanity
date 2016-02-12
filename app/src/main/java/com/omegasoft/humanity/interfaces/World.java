package com.omegasoft.humanity.interfaces;

import java.util.ArrayList;

/**
 * Created by farhad on 16.12.2.
 */
public abstract class World {

    private float startX = 0;
    private float startY = 0;

    private float finishX = 0;
    private float finishY = 0;

    ArrayList<ObjectInWorld> objecstInWorld = new ArrayList<>();

    public World(float startx, float starty, float finishx, float finishy) {
        this.startX = startx;
        this.startY = starty;
        this.finishX = finishx;
        this.finishY = finishy;
    }

    public World(float finishx, float finishy) {
        this(0, 0, finishx, finishy);
    }

    public boolean attachObjectToWorld(ObjectInWorld objectInWorld) {
        if (objecstInWorld.contains(objectInWorld)) return false;

        if (objecstInWorld.add(objectInWorld)) {
            objectInWorld.attachToWorld(this);
        }

        return false;
    }

    public boolean deatachObjectFromWorld(ObjectInWorld objectInWorld) {
        return objecstInWorld.remove(objectInWorld);
    }
}
