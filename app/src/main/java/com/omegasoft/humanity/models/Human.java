package com.omegasoft.humanity.models;

import java.util.Date;

//It is an object that contains a Human details
public class Human {

    //Variables --------------------------------------------------------------------------------------------------

    //if dateOfBirth is null means not exist yet
    private Date dateOfBirth;

    //If dateOfDie is not null means died
    private Date dateOfDie;

    //it is a number between 0 - 10000
    private int Health;

    //it is a number between 0 - 10000
    private int Happiness;

    //it is a number between 0 - 10000
    private int Wise;

    private Location location;

    //a number between -1000 till 1000
    //negative is man and positive is women
    private int sex;

    //Gene of human
    private Gene gene;


    //Variables --------------------------------------------------------------------------------------------------

    //Make a new Human by getting his mother
    public Human(Human father, Human mother) {

        //Make date of birth to Today
        dateOfBirth = new Date();

        //Make child GENE
        gene = makeGene(father.getGene(), mother.getGene());

        //set location to mother location
        location = mother.getLocation();

        //Set Health number
        Health = MakeHealth(gene);

        //Set Happiness number
        Happiness = MakeHappiness(gene);

        //Set Wise number
        Wise = MakeWise(gene);

        //Set sex number
        sex = MakeSex(gene);

    }


    //Moving this human
    //If a direction don't want to change just leave it 0
    //Just difference of directions by positive or negative numbers
    public Location Move(long x, long y, long z) {
        location.setX(location.getX() + x);
        location.setY(location.getY() + y);
        location.setZ(location.getZ() + z);

        return location;
    }

    //Get location of this human
    public Location getLocation() {
        return location;
    }

    //make new Child GENE
    private Gene makeGene(Gene father, Gene mother) {
        //TODO make GENE
        return null;
    }

    //Make Health of child
    private int MakeHealth(Gene gene) {
        //TODO make Health
        return 100;
    }

    //Make Happiness of child
    private int MakeHappiness(Gene gene) {
        //TODO make Happiness
        return 100;
    }

    //Make Wise of child
    private int MakeWise(Gene gene) {
        //TODO make Wise
        return 100;
    }

    //Make sex of child
    private int MakeSex(Gene gene) {
        //TODO make sex
        return 0;
    }

    public Gene getGene() {
        return gene;
    }

    public void setGene(Gene gene) {
        this.gene = gene;
    }

    public void Kill(Date dateOfDie) {
        this.dateOfDie = dateOfDie;
    }

    public boolean isAlive() {
        return this.dateOfDie == null && this.dateOfBirth != null;
    }
}
