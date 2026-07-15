import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Taxi> taxis;

    private int bookingID;

    BookingSystem(int taxiCount){
        taxis = new ArrayList<>();
        for(int i=1 ; i<=taxiCount ; i++){
            taxis.add(new Taxi(i));
        }
    }

    private int calculateCharges(char pickup , char drop){
        int distance = Math.abs(pickup - drop) * 15;
        int charges = 100 ;
        distance -= 5;
        charges += distance * 10;
        return charges;

    }

    Taxi findTaxi(char pickup , int pickupTime){
        List<Taxi> freeTaxis = new ArrayList<>();

//        To traverse the list and choose all the free taxis which can arrive at pickup point at pickuptime

        for(Taxi t:taxis){
            if(t.isFree(pickup, pickupTime)){
                freeTaxis.add(t);
            }
        }

//        If no free taxi available then booking failed

        if (freeTaxis.isEmpty()){
            return null;
        }

        int minDistance = Integer.MAX_VALUE;

//        from the list of free taxi look for the minimum distance required to travel to the pickup Point

        for(Taxi t : freeTaxis){
            int distance = Math.abs(pickup - t.getCurrentSpot());
            minDistance = Math.min(minDistance , distance);
        }
//      with the minDistance choose all the taxis which can arrive to the pickup at minDistance
        List<Taxi>  closest = new ArrayList<>();
        for(Taxi t : freeTaxis){
            int distance = Math.abs(pickup - t.getCurrentSpot());
            if(distance == minDistance){
                closest.add(t);
            }
        }
//       among the closest taxis available choose the one with the minimum earnings (condition provided in question)
        Taxi selected = closest.getFirst();
        for(Taxi t : closest){
            if(t.getEarnings() < selected.getEarnings()){
                selected   = t;
            }
        }

        return selected;

    }


    void bookTaxi(Customer c){
        Taxi selected = findTaxi(c.getPickUp() , c.getPickTime());

        if (selected == null){
            System.out.println("No Taxi available at the moment");
            return;
        }

        int travelTime = Math.abs(c.getPickUp() - c.getDrop());
        int dropTime = c.getPickTime() + travelTime;

        int charges = calculateCharges(c.getPickUp() , c.getDrop());

        Booking booking = new Booking(bookingID , dropTime ,  charges , c );
        bookingID ++;

        selected.assignBookings(booking);
        selected.setFreeTime(dropTime);

        selected.setEarnings(selected.getEarnings() + charges);
        selected.setCurrentSpot(c.getDrop());

        System.out.println("Taxi-" + selected.getTaxiId() + " is allocated");
    }


    void displayTaxi(){
        for (Taxi t: taxis){
            System.out.println("Taxi-" + t.getTaxiId() + " Earnings " + t.getEarnings());
        }
    }
    
}
