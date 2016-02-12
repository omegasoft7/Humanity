package com.omegasoft.humanity.interfaces;

import java.util.ArrayList;

import lombok.Getter;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by farhad on 16.12.2.
 */
public abstract class World {

    @Getter
    private float startX = 0;

    @Getter
    private float startY = 0;

    @Getter
    private float startZ = 0;

    @Getter
    private float finishX = 0;

    @Getter
    private float finishY = 0;

    @Getter
    private float finishZ = 0;

    private ArrayList<ObjectInWorld> objecstInWorld = new ArrayList<>();

    private BehaviorSubject<World> changeSubject = BehaviorSubject.create();


    public World(float startx, float starty, float startz,float finishx, float finishy, float finishz) {
        this.startX = startx;
        this.startY = starty;
        this.startZ = startz;
        this.finishX = finishx;
        this.finishY = finishy;
        this.finishZ = finishz;
    }

    public World(float finishx, float finishy, float finishz) {
        this(0, 0, 0, finishx, finishy, finishz);
    }

    //2D World
    public World(float finishx, float finishy) {
        this(0, 0, 0, finishx, finishy, 0);
    }

    public boolean attachObjectToWorld(ObjectInWorld objectInWorld) {
        if (objecstInWorld.contains(objectInWorld)) return false;

        if (objecstInWorld.add(objectInWorld)) {
            objectInWorld.attachToWorld(this);
            changeSubject.onNext(this);
        }

        return false;
    }

    public boolean deatachObjectFromWorld(ObjectInWorld objectInWorld) {
        if (objecstInWorld.remove(objectInWorld)) {
            changeSubject.onNext(this);
            return true;
        }

        return false;
    }

    public Observable<World> change() {
        return changeSubject.asObservable();
    }
}
