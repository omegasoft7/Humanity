package com.omegasoft.humanity.models;


//It is an object that contains location of other objects
public class Location {

	
	//Variables --------------------------------------------------------------------------------------------------
	
	long X;
	long Y;
	long Z;
	
	
	//Variables --------------------------------------------------------------------------------------------------
	
	
	
	//Make a location by another human location
	public Location(Human human) {
		setX(human.getLocation().getX());
		setY(human.getLocation().getY());
		setZ(human.getLocation().getZ());
	}
	
	
	//make new location the same with received location
	public Location(Location location) {
		setX(location.getX());
		setY(location.getY());
		setZ(location.getZ());
	}
	
	
	//Make new location with points
	public Location(long x, long y, long z) {
		setX(x);
		setY(y);
		setZ(z);
	}


	public long getX() {
		return X;
	}


	public void setX(long x) {
		X = x;
	}


	public long getY() {
		return Y;
	}


	public void setY(long y) {
		Y = y;
	}


	public long getZ() {
		return Z;
	}


	public void setZ(long z) {
		Z = z;
	}
}
