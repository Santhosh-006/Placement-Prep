import java.util.*;

public class Train {

    private int trainId;
    private List<Coach> coaches;
    private Map<CoachType , Queue<Passenger>> waitingList;

    Train(int trainId , int acCount , int sleeperCount , int seaterCount){
        this.trainId = trainId;

        this.coaches = new ArrayList<>();

        this.waitingList = new HashMap<>();

        int coachId = 1;

        for (int i = 0; i < acCount; i++) {
            coaches.add(new Coach(coachId , CoachType.AC));
            coachId++;
        }
        for (int i = 0; i < sleeperCount; i++) {
            coaches.add(new Coach(coachId , CoachType.SLEEPER));
            coachId++;
        }
        for (int i = 0; i < seaterCount; i++) {
            coaches.add(new Coach(coachId , CoachType.SEATER));
            coachId++;
        }
    }

    public int getTrainId() {
        return trainId;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public int getWaitingListSize(){
        int size = 0;

        for(Queue<Passenger> queue : waitingList.values()){
            size += queue.size();
        }

        return size;
    }

    public void addToWaitingList(Passenger passenger, CoachType coachType){
        Queue<Passenger> queue = waitingList.get(coachType);

        if(queue == null){
            queue = new LinkedList<>();
            waitingList.put(coachType , queue);
        }

        queue.offer(passenger);
    }

    public void removeFromWaitingList(Passenger passenger , CoachType coachType){
        Queue<Passenger>  queue = waitingList.get(coachType);

        if(queue != null){
            queue.remove(passenger);
        }
    }

    public Passenger getNextWaitingPassenger(CoachType coachType){
        Queue<Passenger> queue = waitingList.get(coachType);

        if(queue == null || queue.isEmpty()){
            return null;
        }

        return queue.poll();
    }
}

