package HotelResv;

public class Hotel {
    private int reservationId;
    private String guestName;
    private int roomNumber;
    private String contactNumber;

    public Hotel() {

    }

    public Hotel(String guestName, int roomNumber, String contactNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.contactNumber = contactNumber;
    }

    public Hotel(int reservationId, String guestName, int roomNumber, String contactNumber) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.contactNumber = contactNumber;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Hotel [reservationId=" + reservationId + ", guestName=" + guestName + ", roomNumber=" + roomNumber
                + ", contactNumber=" + contactNumber + "]";
    }

}