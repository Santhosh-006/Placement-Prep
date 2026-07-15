import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private char currentSpot;
    private int freeTime;
    private int earnings;
    private List<Booking> bookings;


    Taxi(int taxiId){
        this.taxiId = taxiId;
        this.currentSpot = 'A';
        this.freeTime = 0;
        this.earnings = 0;
        bookings = new ArrayList<>();
    }


    public boolean isFree(char pickUpPoint , int pickUpTime){
        int travelTime = Math.abs(pickUpPoint - currentSpot) ;
        return freeTime+travelTime <= pickUpTime;
    }

    public void assignBookings(Booking b){
        bookings.add(b);
    }

    public int getTaxiId() {
        return taxiId;
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public int getEarnings() {
        return earnings;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
