public class Reservation {
    private long reservationCode;
    private long reservationNumber;
    private enum reservationStatus;

    public long getReservationCode() {
        return reservationCode;
    }

    public long getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationCode(long reservationCode) {
        this.reservationCode = reservationCode;
    }

    public void setReservationNumber(long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
