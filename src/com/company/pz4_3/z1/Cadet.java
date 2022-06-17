package com.company.pz4_3.z1;

public class Cadet {

    int id ;
    String fName;
    String lName;
    SpecialityTrends speciality;

    public Cadet of(int id, String fName, String lName, SpecialityTrends speciality) {
        if (id<=31) {


            this.id = id;
            this.fName = fName;
            this.lName = lName;
            this.speciality = speciality;
            return this;
        }
        return null;
    }

    @Override
    public String toString() {
        return  "id:"+id+" lN:"+lName +" fN:" + fName+" S:"+speciality.toString();
    }
}


