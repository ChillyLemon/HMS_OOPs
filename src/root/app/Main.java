package root.app;

import root.db.DocDB;
import root.db.PatDB;
import root.gui.Entry;

import java.io.IOException;

public class Main {

    public PatDB patDB;
    public DocDB docDB;

    public Main() throws IOException {
        patDB = new PatDB();
        docDB = new DocDB();
    }

    public static void main(String[] args) throws IOException {
        Main obj = new Main();
        new Entry(obj);
    }
}
