package root.var;

import root.People;

public class Doctor extends People {
    public String id;
    public String dept;

    public Doctor(String n, String g, String d, String cn, String bg, String dp){
        name = n;
        gender = g;
        dob = d;
        ct_num = cn;
        blood_Group = bg;
        dept = dp;
    }
    public Doctor(String id, String name, String gender, String dob, String ctnum, String bg, String dept){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.ct_num = ctnum;
        this.blood_Group = bg;
        this.dept = dept;
    }

    public void putID(String x){
        id = x;
    }
}