package root.db;

import root.var.Doctor;
import root.var.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DocDB {
    private final String file = "src/root/db/doc_index.txt";
    private final String db = "src/root/db/doc_database.txt";
    private int idx;
    public ArrayList<Doctor> master;
    BufferedWriter writer;

    public DocDB() throws IOException {
        master = new ArrayList<>();
        writer = new BufferedWriter(new FileWriter(db, true));
        loadData();
    }

    void updateIndex() throws IOException {
        BufferedReader x = new BufferedReader(new FileReader(file));
        idx = Integer.parseInt(x.readLine());
        x.close();
    }

    void updateFile() throws IOException {
        BufferedWriter x = new BufferedWriter(new FileWriter(file));
        x.write(idx + "\n");
        x.close();
    }

    public Doctor add(Doctor d) throws IOException {
        this.updateIndex();
        idx++;
        this.updateFile();
        this.putID(d);
        this.master.add(d);
        writer.write(
                d.id + "\t" + d.name + "\t" + d.gender + "\t" + d.dob + "\t" +
                        d.ct_num + "\t" + d.blood_Group + "\t" + d.dept + "\n"
        );
        writer.flush();
        return d;
    }

    void putID(Doctor d){
        d.putID(d.dept.toUpperCase().substring(0, 2) + (1000 + idx));
    }

    private void loadData() throws IOException {
        BufferedReader x = new BufferedReader(new FileReader(db));
        StringTokenizer st;
        updateIndex();
        x.readLine();
        for (int i = 0; i <= idx; i++) {
            st = new StringTokenizer(x.readLine(), "\t");
            master.add(new Doctor(st.nextToken(), st.nextToken(), st.nextToken(),
                    st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken())
            );
        }
    }
    public int getIDX(){ return idx; }
}
