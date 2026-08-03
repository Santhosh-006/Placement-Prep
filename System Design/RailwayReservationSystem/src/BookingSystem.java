import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    List<Train> trains = new ArrayList<>();
    List<Passenger> passengers = new ArrayList<>();
    List<Ticket> tickets = new ArrayList<>();
    int nextTicketId = 1;


    public void createTrain(int trainId , int acCount , int sleeperCount , int seaterCount){
        trains.add((new Train(trainId , acCount , sleeperCount , seaterCount)));
    }

    public void createPassenger(int passengerId , String passengerName){
        passengers.add(new Passenger(passengerId , passengerName));
    }


    public int bookTicket(int trainId , int passengerId , CoachType coachType){

        Passenger passenger = BookingSystemUtil.findPassenger(passengerId , passengers);

        if (passenger == null){
            System.out.println("Passenger Not Found");
            return -1;
        }

        if(!BookingSystemUtil.validateBooking(trainId , passenger , trains)){
            return -1;
        }
        Train train  = BookingSystemUtil.findTrain(trainId , trains);
        SeatAllocation allottedSeat = findSeat(train , coachType);
        int ticketId;

        if(allottedSeat != null){

            Seat seat = allottedSeat.getSeat();
            Coach coach = allottedSeat.getCoach();

            seat.setPassenger(passenger);

            ticketId = nextTicketId;

            Ticket ticket = new Ticket(nextTicketId++,train ,coach , passenger , TicketStatus.CONFIRMED, seat , coachType);

            tickets.add(ticket);

            System.out.println("Ticket Booked Successfully");

        }else{
            if(train.getWaitingListSize() >= 15){
                System.out.println("Booking Rejected No seats available--Waiting List is full");
                return -1;
            }

            train.addToWaitingList(passenger , coachType);

            ticketId = nextTicketId;

            Ticket ticket = new Ticket(
                    nextTicketId++,
                    train,
                    null,
                    passenger,
                    TicketStatus.WAITING_LIST,
                    null,
                    coachType
            );

            tickets.add(ticket);
            System.out.println("Ticket added to Waiting List");
        }
        return ticketId;

    }

    public void cancelTicket(int ticketId){
        Ticket ticket = BookingSystemUtil.findTicket(ticketId , tickets);

        if(ticket == null){
            System.out.println("Ticket Not Found");
            return;
        }

        if(ticket.getStatus() == TicketStatus.CANCELLED){
            System.out.println("Ticket Already cancelled");
            return;
        }

        if (ticket.getStatus() == TicketStatus.WAITING_LIST){
            ticket.setStatus(TicketStatus.CANCELLED);

            ticket.getTrain().removeFromWaitingList(ticket.getPassenger() , ticket.getCoachType());
            return;
        }

        if(ticket.getStatus() == TicketStatus.CONFIRMED){
            ticket.setStatus(TicketStatus.CANCELLED);

            Seat seat = ticket.getSeat();
            Coach coach = ticket.getCoach();

            seat.setPassenger(null);

            Passenger waitingListPassenger = ticket.getTrain().getNextWaitingPassenger(ticket.getCoachType());

            System.out.println("Waiting passenger: " + waitingListPassenger);

            if(waitingListPassenger != null){
                Ticket waitingTicket = findWaitingTicket(waitingListPassenger);

                seat.setPassenger(waitingListPassenger);

                waitingTicket.setCoach(coach);
                waitingTicket.setSeat(seat);
                waitingTicket.setStatus(TicketStatus.CONFIRMED);
            }
        }
    }


    public void prepareChart(int trainId){
        Train train = BookingSystemUtil.findTrain(trainId , trains);

        if(train == null){
            System.out.println("Train not found");
            return;
        }

        System.out.println("Train ID" + trainId);
        System.out.println("--------------------------------------");

        for(Coach coach : train.getCoaches()){
            System.out.println("Coach: " + coach.getCoachId()
                    + " | Type: " + coach.getCoachType());

            System.out.println("--------------------------------------------");
            System.out.printf("%-10s %-20s%n", "Seat No", "Passenger");
            System.out.println("--------------------------------------------");

            for (Seat seat : coach.getSeats()) {

                String passengerName;

                if (seat.getPassenger() == null) {
                    passengerName = "AVAILABLE";
                } else {
                    passengerName = seat.getPassenger().getPassengerName();
                }

                System.out.printf(
                        "%-10d %-20s%n",
                        seat.getSeatNo(),
                        passengerName
                );
            }

            System.out.println();
        }
    }

    public SeatAllocation findSeat(Train train , CoachType coachType){

        if(train == null){
            return null;
        }

        for(Coach coach : train.getCoaches()){
            if(coach.getCoachType() != coachType){
                continue;
            }

            for(Seat seat: coach.getSeats()){
                if(seat.getPassenger() == null){
                    return new SeatAllocation(coach , seat);
                }
            }
        }

        return null;
    }

    private Ticket findWaitingTicket(Passenger passenger) {

        for (Ticket ticket : tickets) {

            if (ticket.getPassenger().equals(passenger)
                    && ticket.getStatus() == TicketStatus.WAITING_LIST) {

                return ticket;
            }
        }

        return null;
    }
}
