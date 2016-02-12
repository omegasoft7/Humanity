package com.omegasoft.humanity.models;

import com.omegasoft.humanity.interfaces.AliveObject;

//It is an object that contains a Human details
public class Human extends AliveObject {

    //Variables --------------------------------------------------------------------------------------------------


    //Variables --------------------------------------------------------------------------------------------------

    //Make a new Human by getting his mother
    public Human(Human father, Human mother, String name) {
        super(father, mother, name, 3);
    }

}
