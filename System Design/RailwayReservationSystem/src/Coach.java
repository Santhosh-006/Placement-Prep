import java.util.ArrayList;
import java.util.List;

public class Coach {
    private int coachId;
    private CoachType coachType;
    private List<Seat> seats;

    Coach(int coachId , CoachType type ){
        this.coachId = coachId;
        this.coachType = type;

        seats  = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            seats.add(new Seat(i));
        }

    }

    public int getCoachId() {
        return coachId;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
