import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}

interface StudentDAO {
    void addStudent(Student s);
    Student searchStudent(int id);
    void displayStudents();
}

class StudentDAOImpl implements StudentDAO {
    ArrayList<Student> list = new ArrayList<Student>();

    public void addStudent(Student s) {
        list.add(s);
    }

    public Student searchStudent(int id) {
        for (Student s : list) {
            if (s.id == id) return s;
        }
        return null;
    }

    public void displayStudents() {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAOImpl();

        dao.addStudent(new Student(1, "Arun"));
        dao.addStudent(new Student(2, "Divya"));

        System.out.println("Search result: " + dao.searchStudent(1));
        System.out.println("All students:");
        dao.displayStudents();
    }
}