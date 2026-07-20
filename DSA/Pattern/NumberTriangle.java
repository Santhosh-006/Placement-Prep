
public class NumberTriangle {

// 1
// 2 6
// 3 7 10
// 4 8 11 13
// 5 9 12 14 15
    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i <= n; i++) {
            int counter = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter = counter + (n - j);

            }
            System.out.println("");
        }
    }
}
