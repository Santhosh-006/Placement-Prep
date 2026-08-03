public class Ticket {

    private int ticketId;
    private Train train;
    private Coach coach;
    private CoachType coachType;
    private Passenger passenger;
    private TicketStatus status;
    private Seat seat;

    Ticket(int ticketId , Train train , Coach coach , Passenger passenger , TicketStatus status , Seat seat , CoachType coachType){
        this.ticketId = ticketId;
        this.train = train;
        this.coach = coach;
        this.passenger = passenger;
        this.seat = seat;
        this. status = status;
        this.coachType = coachType;
    }

    public int getTicketId() {
        return ticketId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public Coach getCoach() {
        return coach;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
