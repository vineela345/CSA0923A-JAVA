import java.util.*;

class Patient {
    String name;
    int severity;
    long arrival;

    Patient(String name, int severity, long arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public String toString() {
        return name + "(S" + severity + ")";
    }
}

class Triage {
    private long counter = 0;

    // Lower severity number comes first; earlier arrival breaks ties.
    private PriorityQueue<Patient> queue = new PriorityQueue<>(
            Comparator.comparingInt((Patient p) -> p.severity)
                    .thenComparingLong(p -> p.arrival));

    void admit(String name, int severity) {
        queue.add(new Patient(name, severity, counter++));
    }

    Patient next() {
        return queue.poll();
    }
}

public class Q6_HospitalTriage {
    public static void main(String[] args) {
        Triage er = new Triage();
        er.admit("Meena", 1);
        er.admit("John", 3);
        er.admit("Kumar", 1);
        er.admit("Ravi", 2);
        er.admit("Asha", 5);

        System.out.println("Treatment order:");
        Patient patient;
        while ((patient = er.next()) != null) {
            System.out.println(patient);
        }
    }
}
