
import java.util.Arrays;

public class MergeSortedArray {

//     Question 1: Merge Two Sorted Arrays
//     Input
//     :
//      arr1  = [1, 4, 11, 17]
//       arr2  = [13, 8, 5]
//      Output
//     :
//      [1, 4, 5 ,8 11, 13, 17]
//      Note
//          : The arrays could be sorted either in ascending or descending order.Before coding, we had to explain the approach for all four possible cases
//     :
//      - Both arrays may be in ascending order
//      - Both arrays may be in descending order
//      - First array may be in ascending and second array may be in descending
//      - First array may be in descending and second array may be in ascending
    public static void main(String[] args) {
        // Condition is 2 arrays that may be sorted in any order like ascending or descending.

        int[] a1 = {1, 4, 11, 17};
        int[] a2 = {13, 5, 4};

        if (a1.length == 0 && a2.length > 0) {
            Arrays.sort(a2);
            System.out.println(Arrays.toString(a2));
            return;
        }

        if (a2.length == 0 && a1.length > 0) {
            Arrays.sort(a1);
            System.out.println(Arrays.toString(a1));
            return;
        }

        int[] output = new int[a1.length + a2.length];
        int k = 0;
        boolean a1isAs = true, a2isAs = true;

        if (a1.length == 1 || a2.length == 1) {
            if (a1.length == 1) {
                a1isAs = true;
            } else {
                a2isAs = true;
            }
        } else {
            if (a1[0] > a1[1]) {
                a1isAs = false;
            }
            if (a2[0] > a2[1]) {
                a2isAs = false;
            }
        }

        int p1 = 0, p2 = 0;

        if (!a1isAs) {
            p1 = a1.length - 1;
        }

        if (!a2isAs) {
            p2 = a2.length - 1;
        }

        while (((a1isAs && p1 < a1.length) || (!a1isAs && p1 >= 0)) && ((a2isAs && p2 < a2.length) || (!a2isAs && p2 >= 0))) {

            if (a1[p1] <= a2[p2]) {
                output[k++] = a1[p1];

                if (a1isAs) {
                    p1++;
                } else {
                    p1--;
                }
            } else {
                output[k++] = a2[p2];

                if (a2isAs) {
                    p2++;
                } else {
                    p2--;
                }
            }

        }

        while (((a1isAs && p1 < a1.length) || (!a1isAs && p1 > 0))) {
            output[k++] = a1[p1];

            if (a1isAs) {
                p1++;
            } else {
                p1--;
            }
        }

        while (((a2isAs && p2 < a2.length) || (!a2isAs && p2 > 0))) {
            output[k++] = a2[p2];

            if (a2isAs) {
                p2++;
            } else {
                p2--;
            }
        }

        System.out.println(Arrays.toString(output));

    }
}
