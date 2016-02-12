package com.omegasoft.humanity.interfaces;

import lombok.Getter;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by farhad on 16.12.2.
 */
public abstract class ObjectInWorld {
    private World world;

    @Getter
    private BehaviorSubject<ObjectInWorld> changeSubject = BehaviorSubject.create();

    public void attachToWorld(World world) {
        this.world = world;
    }

    public boolean deatach() {
        return this.world.deatachObjectFromWorld(this);
    }

    public Observable<ObjectInWorld> change() {
        return changeSubject.asObservable();
    }
}
