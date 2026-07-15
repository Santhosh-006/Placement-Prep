//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer(1 , 'A' , 'B' , 9);
        Customer c2 = new Customer(2 , 'B' , 'D' , 9);
        Customer c3 = new Customer(3 , 'B' , 'C' , 12);

        BookingSystem bs = new BookingSystem(4);

        bs.bookTaxi(c1);
        bs.bookTaxi(c2);
        bs.bookTaxi(c3);

        bs.displayTaxi();
    }
}