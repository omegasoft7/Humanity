package com.omegasoft.humanity.interfaces;

import com.omegasoft.humanity.models.Gene;
import com.omegasoft.humanity.models.Location;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by farhad on 16.12.2.
 */
public abstract class AliveObject {

    @Getter
    private final float maxMovementSpeed;
    //Name of Human
    @Getter
    @Setter
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

    public AliveObject(AliveObject father, AliveObject mother, String name, float maxSpeed) {
        setName(name);
        this.dateOfBirth = new Date();

        this.gene = Gene.makeGene(father, mother);

        this.location = mother == null ? new Location() : mother.getLocation();

        this.maxMovementSpeed = maxSpeed;
    }

    public void Kill(Date dateOfDie) {
        this.dateOfDie = dateOfDie;
    }

    public boolean isAlive() {
        return this.dateOfDie == null && this.dateOfBirth != null;
    }

    public Observable<Location> moveTo(Location destination, float speedRate) {
        if (speedRate > 1 || speedRate < 0)
            throw new IllegalArgumentException("speedRate should be a value between 0-1");

        float requestedSpeed = getMaxMovementSpeed() * speedRate;

        return Observable.just(getLocation())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(100, TimeUnit.MILLISECONDS)
                .repeatWhen(o -> o.takeWhile((v -> {
                    getLocation().move(destination, requestedSpeed);
                    return !getLocation().equals(destination);
                })));
    }
}
