package HotelResv;

public interface HotelResvInterface {
    public void reserveRoom(Hotel h);
    public void viewReservations();
    public void getRoomNumber(int reservationId,String guestName);
    public void updateReservations(int reservationId,String guestName,int roomNumber,String contactNumber);
    public void cancelReservations(int reservationId);
    public boolean reservationExists(int reservationId);
}
