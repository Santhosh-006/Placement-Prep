public class Seat {

    private int seatNo;
    private Passenger passenger;

    Seat(int seatNo ){
        this.seatNo = seatNo;
        this.passenger = null;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
