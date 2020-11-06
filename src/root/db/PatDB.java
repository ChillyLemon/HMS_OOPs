package root.db;

import root.var.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PatDB {
    public final String file = "src/root/db/pat_index.txt";
    private final String db = "src/root/db/pat_database.txt";
    private int idm; // master index
    private int idc; // current index
    public ArrayList<ArrayList<Patient>> master;
    ArrayList<Patient> current;
    BufferedWriter writer;

    public PatDB() throws IOException {
        master = new ArrayList<>();
        current = new ArrayList<>();
        master.add(current);
        writer = new BufferedWriter(new FileWriter(db, true));
        loadData();
    }

    void updateIndex() throws IOException {
        BufferedReader x = new BufferedReader(new FileReader(file));
        StringTokenizer st = new StringTokenizer(x.readLine());
        idm = Integer.parseInt(st.nextToken());
        idc = Integer.parseInt(st.nextToken());
        x.close();
    }

    void updateFile() throws IOException {
        BufferedWriter x = new BufferedWriter(new FileWriter(file));
        x.write(idm + " " + idc + "\n");
        x.close();
    }

    public Patient add(Patient p) throws IOException {
        this.updateIndex();
        if(idc == 99){
            idc = 0;
            idm++;
            current = new ArrayList<>();
            master.add(current);
        } else {
            idc++;
        }
        this.updateFile();
        this.putID(p);
        this.master.get(idm).add(p);
        writer.write(
                p.id + "\t" + p.time.toString() + "\t" +
                        p.name + "\t" + p.gender + "\t" + p.dob + "\t" +
                        p.ct_num + "\t" + p.blood_Group + "\t" +
                        p.dept + "\t" + (p.emergency ? "YES" : "NO") + "\n"
        );
        writer.flush();
        return p;
    }

    void putID(Patient p){
        p.putID("1" + (1000 * (idm + 1) + idc));
    }

    void loadData() throws IOException {
        BufferedReader x = new BufferedReader(new FileReader(db));
        StringTokenizer st;
        updateIndex();
        x.readLine();

        for (int j = 0; j < idm; j++){
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(x.readLine(), "\t");
                master.get(j).add(new Patient(st.nextToken(), st.nextToken(),
                        st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
                        st.nextToken(), st.nextToken(), st.nextToken().equals("YES"))
                );
            }
        }
        for (int i = 0; i <= idc; i++){
            st = new StringTokenizer(x.readLine(), "\t");
            master.get(idm).add(new Patient(st.nextToken(), st.nextToken(),
                    st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
                    st.nextToken(), st.nextToken(), st.nextToken().equals("YES"))
                    );
        }
    }

    public int getIDM(){ return idm; }
    public int getIDC(){ return idc; }
}
