package root.dep;

import root.db.DocDB;
import root.var.Doctor;
import root.var.Patient;

import java.util.ArrayList;
import java.util.HashMap;

public class Department {
    public static final String[] list = {"Cardiology", "Dermatology", "ENT", "Emergency",
            "GenSurgery", "ICU", "Neurology", "Oncology", "OPD", "Orthopedics", "Pediatrics"
    };
    public static String Cardiology = "CD";
    public static String Dermatology = "DM";
    public static String ENT = "EN";
    public static String Emergency = "EM";
    public static String GenSurgery = "GS";
    public static String ICU = "IC";
    public static String Neurology = "NU";
    public static String Oncology = "OC";
    public static String OPD = "OP";
    public static String Orthopedics = "OR";
    public static String Pediatrics = "PD";

    protected DocDB docDB;

}
