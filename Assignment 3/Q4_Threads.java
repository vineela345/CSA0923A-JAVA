class Station extends Thread {
    int scripts;

    Station(String name, int scripts) {
        super(name);
        this.scripts = scripts;
    }

    public void run() {
        System.out.println(getName() + " started");

        for (int i = 1; i <= scripts; i++) {
            System.out.println(getName() + " scanned script " + i);
        }

        System.out.println(getName() + " finished");
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Station s1 = new Station("Station-1", 3);
        Station s2 = new Station("Station-2", 2);

        System.out.println("Before start: " + s1.getState());

        s1.start();
        s2.start();

        s1.join();
        s2.join();

        System.out.println("After join: " + s1.getState());
        System.out.println("All stations completed");
    }
}
