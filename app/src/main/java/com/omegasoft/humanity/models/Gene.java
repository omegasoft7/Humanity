package com.omegasoft.humanity.models;

import com.omegasoft.humanity.interfaces.AliveObject;

import java.util.ArrayList;

//Gene for human
public class Gene {

	//Variables --------------------------------------------------------------------------------------------------
	private ArrayList<Gene> geneHistory = new ArrayList<>(100);

    //a number between -1 till 1
    //negative is man and positive is women
    private float sex;

    //it is a number between 0 - 10000
    private int HealthRate;

    //it is a number between 0 - 10000
    private int HappinessRate;

    //it is a number between 0 - 10000
    private int IQRate;

	//Variables --------------------------------------------------------------------------------------------------
	public Gene() {
		// TODO Auto-generated constructor stub
	}

    //make new Child GENE
    public static Gene makeGene(Gene father, Gene mother) {
        //TODO make GENE
        return null;
    }

    //make new Child GENE
    public static Gene makeGene(AliveObject father, AliveObject mother) {
        //TODO make GENE
        return null;
    }
}
