import java.util.HashSet;
import java.util.Set;

class Student {
    private final String regNo;
    private final String name;

    Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return regNo.equals(other.regNo);
    }

    // TODO 1 completed: equal students must have the same hash code.
    @Override
    public int hashCode() {
        return regNo.hashCode();
    }

    @Override
    public String toString() {
        return regNo + " - " + name;
    }
}

public class Q3_AttendanceHashSet {
    public static void main(String[] args) {
        Set<Student> present = new HashSet<>();

        // Same scan set: one duplicate scan
        present.add(new Student("192311001", "Arun"));
        present.add(new Student("192311002", "Divya"));
        present.add(new Student("192311001", "Arun"));

        System.out.println("Unique students: " + present.size());
        System.out.println("Students: " + present);

        // A second test: same registration number, different name.
        present.add(new Student("192311001", "Arun Kumar"));
        System.out.println("After adding same regNo again: " + present.size());
    }
}
