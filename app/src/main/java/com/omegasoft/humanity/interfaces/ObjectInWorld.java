package com.omegasoft.humanity.interfaces;

/**
 * Created by farhad on 16.12.2.
 */
public abstract class ObjectInWorld {
    private World world;

    public void attachToWorld(World world) {
        this.world = world;
    }

    public boolean deatach() {
        return this.world.deatachObjectFromWorld(this);
    }
}
