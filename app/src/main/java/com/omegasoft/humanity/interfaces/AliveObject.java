package com.omegasoft.humanity.interfaces;

import com.omegasoft.humanity.humanity.HumanityAPP;
import com.omegasoft.humanity.models.Gene;
import com.omegasoft.humanity.models.Location;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by farhad on 16.12.2.
 */
public abstract class AliveObject {

    @Getter
    private final float maxMovementSpeed;
    //Name of Human
    @Getter
    private String name;

    //if dateOfBirth is null means not exist yet
    @Getter
    private Date dateOfBirth;

    //If dateOfDie is not null means died
    @Getter
    private Date dateOfDie;

    @Getter
    private Location location;

    //Gene of human
    @Getter
    private Gene gene;

    @Getter
    private BehaviorSubject<AliveObject> changeSubject = BehaviorSubject.create();

    @Getter
    private World world;

    public AliveObject(AliveObject father, AliveObject mother, String name, float maxSpeed) {
        this.name = name;

        this.dateOfBirth = new Date();

        this.gene = Gene.makeGene(father, mother);

        this.location = mother == null ? new Location() : mother.getLocation();

        this.maxMovementSpeed = maxSpeed;
        getChangeSubject().onNext(this);
    }

    public void attachToWorld(World world) {
        this.world = world;
    }

    public boolean deatach() {
        return this.world.deatachObjectFromWorld(this);
    }

    public void Kill(Date dateOfDie) {
        this.dateOfDie = dateOfDie;
        getChangeSubject().onNext(this);
    }

    public boolean isAlive() {
        return this.dateOfDie == null && this.dateOfBirth != null;
    }

    public Observable<Location> moveTo(Location destination, float speedRate) {
        if (speedRate > 1 || speedRate < 0)
            throw new IllegalArgumentException("speedRate should be a value between 0-1");

        BehaviorSubject<Location> behaviorSubject = BehaviorSubject.create();

        //Make sure that destination location is not bigger that world limitations
        destination.setX(Math.min(destination.getX(), (getWorld().getFinishX() - getWorld().getStartX())));
        destination.setY(Math.min(destination.getY(), (getWorld().getFinishY() - getWorld().getStartY())));
        destination.setZ(Math.min(destination.getZ(), (getWorld().getFinishZ() - getWorld().getStartZ())));

        float requestedSpeed = getMaxMovementSpeed() * speedRate;

        Observable.just(getLocation())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(HumanityAPP.delayForEachFrame, TimeUnit.MILLISECONDS)
                .repeatWhen(o -> o.takeWhile((v -> {
                    getLocation().move(destination, requestedSpeed);
                    getChangeSubject().onNext(this);
                    return !getLocation().equals(destination);
                })))
                .subscribe(behaviorSubject);

        return behaviorSubject.asObservable();
    }

    public void notifyChange() {
        getChangeSubject().onNext(this);
    }

    public Observable<AliveObject> change() {
        return changeSubject.asObservable();
    }
}
