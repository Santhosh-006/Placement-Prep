public class SeatAllocation {

    private Coach coach;
    private Seat seat;

    public SeatAllocation(Coach coach, Seat seat) {
        this.coach = coach;
        this.seat = seat;
    }

    public Coach getCoach() {
        return coach;
    }

    public Seat getSeat() {
        return seat;
    }
}