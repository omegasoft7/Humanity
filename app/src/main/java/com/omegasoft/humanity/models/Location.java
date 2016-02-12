package com.omegasoft.humanity.models;


import lombok.Getter;
import lombok.Setter;

//It is an object that contains location of other objects
public class Location {

	
	//Variables --------------------------------------------------------------------------------------------------

    @Getter @Setter
	private float X = 0;

    @Getter @Setter
    private float Y = 0;

    @Getter @Setter
    private float Z = 0;

	//Variables --------------------------------------------------------------------------------------------------

    public Location() {

    }

	//Make a location by another human location
	public Location(Human human) {
		this.X = human.getLocation().getX();
        this.Y = human.getLocation().getY();
        this.Z = human.getLocation().getZ();
	}
	
	
	//make new location the same with received location
	public Location(Location location) {
        this.X = location.getX();
        this.Y = location.getY();
        this.Z = location.getZ();
	}
	
	//Make new location with points
	public Location(float x, float y, float z) {
        this.X = x;
        this.Y = y;
        this.Z = z;
	}

    //Make new location with 2D points
    public Location(float x, float y) {
        this(x, y, 0);
    }

    public void move(Location destination, float steps) {

        //Move X
        if (getX() > destination.getX()) {
            this.X -= Math.min((getX() - destination.getX()), steps);
        } else if (getX() < destination.getX()) {
            this.X += Math.min((destination.getX() - getX()), steps);
        }

        //Move Y
        if (getY() > destination.getY()) {
            this.Y -= Math.min((getY() - destination.getY()), steps);
        } else if (getY() < destination.getY()) {
            this.Y += Math.min((destination.getY() - getY()), steps);
        }

        //Move Z
        if (getZ() > destination.getZ()) {
            this.Z -= Math.min((getZ() - destination.getZ()), steps);
        } else if (getZ() < destination.getZ()) {
            this.Z += Math.min((destination.getZ() - getZ()), steps);
        }
    }

    @Override
    public boolean equals(Object loc) {
        if (!(loc instanceof Location)) return false;

        Location _loc = (Location) loc;
        if (_loc == null) return false;

        return _loc.getX() == getX() && _loc.getY() == getY() && _loc.getZ() == getZ();
    }

    @Override
    public String toString() {
        return "X:" + getX() + " Y:" + getY() + " Z:" + getZ();
    }
}
