import java.io.*;

class Resident implements Serializable {
    String name;
    String registerNo;
    transient String password;

    Resident(String name, String registerNo, String password) {
        this.name = name;
        this.registerNo = registerNo;
        this.password = password;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Resident r = new Resident("Arun", "192311001", "abc123");

        ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream("resident.txt"));
        out.writeObject(r);
        out.close();

        ObjectInputStream in =
            new ObjectInputStream(new FileInputStream("resident.txt"));
        Resident saved = (Resident) in.readObject();
        in.close();

        System.out.println("Name: " + saved.name);
        System.out.println("Register Number: " + saved.registerNo);
        System.out.println("Password: " + saved.password);
        System.out.println("Transient password is not saved.");
    }
}