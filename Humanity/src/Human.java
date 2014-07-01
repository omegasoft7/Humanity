import java.util.Date;

//It is an object that contains a Human details
public class Human {

	//Variables --------------------------------------------------------------------------------------------------
	
	
	Date dateOfBirth;
	Date dateOfDie;
	
	long Happiness;
	
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
		
		
		//Set Happiness number
		Happiness = MakeHappiness(father, mother);
		
		
		//Set sex number
		sex = MakeSex(father, mother);
	}


	
	//Get location of this human
	public Location getLocation() {
		return location;
	}
	
	
	
	//Make Happiness of child
	private long MakeHappiness(Human father, Human mother){
		//TODO make Happiness
		return 0;
	}
	
	//Make sex of child
	private long MakeSex(Human father, Human mother){
		//TODO make sex
		return 0;
	}
}
