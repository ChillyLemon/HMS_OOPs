package root.var;

import root.People;

import java.time.LocalDateTime;

public class Patient extends People {
    public String id;
    public boolean emergency;
    public String dept;
    public LocalDateTime time;

    public Patient(String n, String g, String d, String cn, String bg, String dp, boolean em){
        name = n;
        gender = g;
        dob = d;
        ct_num = cn;
        blood_Group = bg;
        dept = dp;
        emergency = em;
        time = LocalDateTime.now();
    }
    public Patient(String id, String time, String name, String gender, String dob, String ctnum, String bg, String dept, boolean em){
        this.id = id;
        this.time = LocalDateTime.parse(time);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.ct_num = ctnum;
        this.blood_Group = bg;
        this.dept = dept;
        this.emergency = em;
    }

    public void putID(String x) {
        id = x;
    }
}
