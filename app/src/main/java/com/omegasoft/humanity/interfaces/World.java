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

    @Getter
    private int color;

    @Getter
    private ArrayList<AliveObject> objecstInWorld = new ArrayList<>();

    private BehaviorSubject<World> changeSubject = BehaviorSubject.create();


    public World(int color, float startx, float starty, float startz,float finishx, float finishy, float finishz) {
        this.color = color;
        this.startX = startx;
        this.startY = starty;
        this.startZ = startz;
        this.finishX = finishx;
        this.finishY = finishy;
        this.finishZ = finishz;
    }

    public World(int color, float finishx, float finishy, float finishz) {
        this(color, 0, 0, 0, finishx, finishy, finishz);
    }

    //2D World
    public World(int color, float finishx, float finishy) {
        this(color, 0, 0, 0, finishx, finishy, 0);
    }

    public boolean attachObjectToWorld(AliveObject aliveObject) {
        if (objecstInWorld.contains(aliveObject)) return false;

        if (objecstInWorld.add(aliveObject)) {
            aliveObject.attachToWorld(this);
            changeSubject.onNext(this);
        }

        return false;
    }

    public boolean deatachObjectFromWorld(AliveObject aliveObject) {
        if (objecstInWorld.remove(aliveObject)) {
            changeSubject.onNext(this);
            return true;
        }

        return false;
    }

    public Observable<World> change() {
        return changeSubject.asObservable();
    }
}
