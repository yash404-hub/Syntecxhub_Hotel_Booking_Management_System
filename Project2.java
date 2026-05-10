// Yash Kumar Gupta
import java.util.*;

class HotelBookingManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> availableRooms = new ArrayList<>();
    static ArrayList<Integer> bookedRooms = new ArrayList<>();

    public static void initializeRooms() {
        for (int i = 101; i <= 110; i++) {
            availableRooms.add(i);
        }
    }

    public static void viewAvailableRooms() {
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            System.out.println("Available Rooms:");
            for (int room : availableRooms) {
                System.out.println("Room " + room);
            }
        }
    }

    public static void bookRoom() {
        System.out.print("Enter room number to book: ");

        try {
            int room = Integer.parseInt(sc.nextLine());

            if (availableRooms.contains(room)) {
                availableRooms.remove(Integer.valueOf(room));
                bookedRooms.add(room);
                System.out.println("Room booked successfully!");
            } else {
                System.out.println("Room not available.");
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    public static void cancelBooking() {
        System.out.print("Enter room number to cancel booking: ");

        try {
            int room = Integer.parseInt(sc.nextLine());

            if (bookedRooms.contains(room)) {
                bookedRooms.remove(Integer.valueOf(room));
                availableRooms.add(room);
                Collections.sort(availableRooms);

                System.out.println("Booking cancelled successfully!");
            } else {
                System.out.println("Room is not booked.");
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    public static void viewBookedRooms() {
        if (bookedRooms.isEmpty()) {
            System.out.println("No rooms booked.");
        } else {
            System.out.println("Booked Rooms:");
            for (int room : bookedRooms) {
                System.out.println("Room  " + room);
            }
        }
    }

    public static void main(String[] args) {

        initializeRooms();

        int choice;

        do {
            System.out.println("\n===== Hotel Booking Management System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booked Rooms");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        viewAvailableRooms();
                        break;

                    case 2:
                        bookRoom();
                        break;

                    case 3:
                        cancelBooking();
                        break;

                    case 4:
                        viewBookedRooms();
                        break;

                    case 5:
                        System.out.println("Program Closed.");
                        break;

                    default:
                        System.out.println("Invalid choice! Please enter 1 to 5.");
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 5);
    }
}