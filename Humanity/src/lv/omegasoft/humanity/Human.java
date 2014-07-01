package lv.omegasoft.humanity;

import java.util.Date;

//It is an object that contains a Human details
public class Human {

	//Variables --------------------------------------------------------------------------------------------------
	
	//if dateOfBirth is null means not exist yet
	Date dateOfBirth;
	
	//If dateOfDie is not null means died
	Date dateOfDie;
	
	
	
	//it is a number between 0 - 10000
	long Health;
	
	//it is a number between 0 - 10000
	long Happiness;
	
	//it is a number between 0 - 10000
	long Wise;
	
	
	Location location;
	
	//a number between -1000 till 1000
	//negative is man and positive is women 
	long sex;
	
	
	//Variables --------------------------------------------------------------------------------------------------
	
	//Make a new Human by getting his mother
	public Human(Human father, Human mother) {
		
		//Make date of birth to Today
		dateOfBirth = new Date();
		
		
		//set location to mother location
		location = mother.getLocation();
		
		
		
		//Set Health number
		Health = MakeHealth(father, mother);
		
		
		//Set Happiness number
		Happiness = MakeHappiness(father, mother);
		
		//Set Wise number
		Wise = MakeWise(father, mother);
				
		
		//Set sex number
		sex = MakeSex(father, mother);
	}


	
	//Get location of this human
	public Location getLocation() {
		return location;
	}
	
	
	
	//Make Health of child
	private long MakeHealth(Human father, Human mother){
		//TODO make Health
		return 100;
	}
	
	//Make Happiness of child
	private long MakeHappiness(Human father, Human mother){
		//TODO make Happiness
		return 100;
	}
	
	
	//Make Wise of child
	private long MakeWise(Human father, Human mother){
		//TODO make Wise
		return 100;
	}

	//Make sex of child
	private long MakeSex(Human father, Human mother){
		//TODO make sex
		return 0;
	}
}
