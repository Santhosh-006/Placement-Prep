import java.util.List;

public class BookingSystemUtil {

    static boolean validateBooking(int trainId , Passenger passenger  , List<Train> trains ){

        boolean trainExists = false;

        for (Train train : trains) {
            if (train.getTrainId() == trainId) {
                trainExists = true;
                break;
            }
        }

        if (!trainExists) {
            System.out.println("Train not Available");
            return false;
        }

        if(passenger == null){
            System.out.println("Invalid Passenger");
            return false;
        }

        return true;
    }

    static Train findTrain(int trainId , List<Train> trains){
        for(Train train : trains){
            if(trainId == train.getTrainId()){
                return train;
            }
        }

        return null;
    }

    static Passenger findPassenger(int passengerId , List<Passenger> passengers){
        for(Passenger passenger : passengers){
            if(passenger.getPassengerId() == passengerId){
                return passenger;
            }
        }

        return null;
    }

    static Ticket findTicket(int ticketId , List<Ticket> tickets){
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }

        return null;
    }
}
