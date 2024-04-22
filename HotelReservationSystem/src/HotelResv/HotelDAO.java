package HotelResv;

import java.util.*;
import java.sql.*;

public class HotelDAO implements HotelResvInterface {

    @Override
    public void reserveRoom(Hotel h) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "insert into reservations(guest_name,room_number,contact_number) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, h.getGuestName());
            pst.setInt(2, h.getRoomNumber());
            pst.setString(3, h.getContactNumber());
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Reservation failed.");
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewReservations() {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "select * from reservations";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            System.out.println("Current Reservations:");
            System.out.println(
                    "+----------------+-----------------+---------------+----------------------+-------------------------+");
            System.out.println(
                    "| Reservation ID | Guest           | Room Number   | Contact Number       | Reservation Date        |");
            System.out.println(
                    "+----------------+-----------------+---------------+----------------------+-------------------------+");
            while (result.next()) {
                int reservationId = result.getInt("reservation_id");
                String guestName = result.getString("guest_name");
                int roomNumber = result.getInt("room_number");
                String contactNumber = result.getString("contact_number");
                String reservationDate = result.getTimestamp("reservation_date").toString();

                // Format and display the reservation data in a table-like format
                System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s   |\n",
                        reservationId, guestName, roomNumber, contactNumber, reservationDate);
            }

            System.out.println(
                    "+----------------+-----------------+---------------+----------------------+-------------------------+");
            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getRoomNumber(int reservationId, String guestName) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "SELECT room_number FROM reservations " +
                    "WHERE reservation_id = " + reservationId +
                    " AND guest_name = '" + guestName + "'";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                int roomNumber = result.getInt("room_number");
                System.out.println("Room number for Reservation ID " + reservationId +
                        " and Guest " + guestName + " is: " + roomNumber);
            } else {
                System.out.println("Reservation not found for the given ID and guest name.");
            }
            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReservations(int reservationId, String guestName, int roomNumber, String contactNumber) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "UPDATE reservations SET guest_name = '" + guestName + "', " +
                    "room_number = " + roomNumber + ", " +
                    "contact_number = '" + contactNumber + "' " +
                    "WHERE reservation_id = " + reservationId;
            Statement stmt = con.createStatement();
            int affectedRows = stmt.executeUpdate(sql);
            if (affectedRows > 0) {
                System.out.println("Reservation updated successfully!");
            } else {
                System.out.println("Reservation update failed.");
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelReservations(int reservationId) {
        try {
            Connection con = DBConnection.createConnection();
            String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;
            Statement stmt = con.createStatement();
            int affectedRows = stmt.executeUpdate(sql);
            if (affectedRows > 0) {
                System.out.println("Reservation deleted successfully!");
            } else {
                System.out.println("Reservation deletion failed.");
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean reservationExists(int reservationId) {
       try {
        Connection con =  DBConnection.createConnection();
        String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = " + reservationId;
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        return result.next(); // If there's a result, the reservation exists
       } catch (Exception e) {
        e.printStackTrace();
            return false; // Handle database errors as needed
        }
    }

}
