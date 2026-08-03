//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BookingSystem bs = new BookingSystem();

        bs.createTrain(12345 , 1,0,0);

        bs.createPassenger(1 , "AAA");
        bs.createPassenger(2 , "BBB");
        bs.createPassenger(3 , "CCC");
        bs.createPassenger(4 , "DDD");
        bs.createPassenger(5 , "EEE");
        bs.createPassenger(6 , "FFF");
        bs.createPassenger(7 , "GGG");
        bs.createPassenger(8 , "HHH");


       int ticketId = bs.bookTicket(12345 , 1 , CoachType.AC);
        bs.bookTicket(12345 , 2 , CoachType.AC);
        bs.bookTicket(12345 , 3 , CoachType.AC);
        bs.bookTicket(12345 , 4 , CoachType.AC);
        bs.bookTicket(12345 , 5 , CoachType.AC);
        bs.bookTicket(12345 , 6 , CoachType.AC);

        bs.cancelTicket(ticketId);

        bs.prepareChart(12345);


    }
}