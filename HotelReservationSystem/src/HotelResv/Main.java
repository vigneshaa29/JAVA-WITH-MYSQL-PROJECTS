package HotelResv;

import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        String guestName;
        int reservationId;
        Scanner sc = new Scanner(System.in);

        HotelResvInterface hotel = new HotelDAO();
        System.out.println("Welcome to Hotel Reservation System");
        while (true) {
            System.out.println();
            System.out.println("HOTEL RESERVATION SYSTEM");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Reserve a room");
            System.out.println("2. View Reservations");
            System.out.println("3. Get Room Number");
            System.out.println("4. Update Reservations");
            System.out.println("5. Cancel Reservations");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Reserve Room");
                    System.out.print("Enter guest name: ");
                    guestName = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.next();
                    Hotel dao = new Hotel(guestName, roomNumber, contactNumber);
                    hotel.reserveRoom(dao);
                    break;
                case 2:
                    hotel.viewReservations();
                    break;
                case 3:
                    System.out.print("Enter reservation ID: ");
                    reservationId = scanner.nextInt();
                    System.out.print("Enter guest name: ");
                    guestName = scanner.next();
                    hotel.getRoomNumber(reservationId, guestName);
                    break;
                case 4:
                System.out.print("Enter reservation ID to update: ");
                reservationId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
    
                if (!hotel.reservationExists(reservationId))
                 {
                    System.out.println("Reservation not found for the given ID.");
                    return;
                 }
                 System.out.print("Enter new guest name: ");
            String newGuestName = scanner.nextLine();
            System.out.print("Enter new room number: ");
            int newRoomNumber = scanner.nextInt();
            System.out.print("Enter new contact number: ");
            String newContactNumber = scanner.next();
            hotel.updateReservations(reservationId, newGuestName, newRoomNumber, newContactNumber);
            break;
            case 5:
            System.out.print("Enter reservation ID to delete: ");
            reservationId = scanner.nextInt();

            if (!hotel.reservationExists(reservationId)) {
                System.out.println("Reservation not found for the given ID.");
                return;
            }
            hotel.cancelReservations(reservationId);
            break;
            case 6:
            exit();
            scanner.close();
            return;
            default:
            System.out.println("Invalid choice. Try again.");
            } 
        }

    }
    
    public static void exit() throws InterruptedException {
        System.out.print("Exiting System");
        int i = 5;
        while(i!=0){
            System.out.print(".");
            Thread.sleep(1000);
            i--;
        }
        System.out.println();
        System.out.println("Thank You For Using Hotel Reservation System!!!");
    }
}
