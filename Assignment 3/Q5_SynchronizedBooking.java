class SeatBooking {
    boolean[] booked = new boolean[5];

    // synchronized prevents two users from booking the same seat
    synchronized void book(int seat) {
        if (!booked[seat]) {
            booked[seat] = true;
            System.out.println("Seat " + seat + " booked");
        } else {
            System.out.println("Seat " + seat + " is already booked");
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        SeatBooking cinema = new SeatBooking();

        Thread user1 = new Thread(() -> cinema.book(2));
        Thread user2 = new Thread(() -> cinema.book(2));

        user1.start();
        user2.start();

        user1.join();
        user2.join();
    }
}
