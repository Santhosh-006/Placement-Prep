public class Passenger {

    private int passengerId;
    private String passengerName;

    Passenger(int passengerId , String passengerName){
        this.passengerId = passengerId;
        this.passengerName = passengerName;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }
}
