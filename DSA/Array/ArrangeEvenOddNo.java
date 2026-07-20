
import java.util.Arrays;

public class ArrangeEvenOddNo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int p = 0;
        // O(n) approach
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                p++;
            }
        }

        int[] nums = {1, 2, 3, 4, 5, 6};
        int low = 0, high = nums.length - 1;

        while (low < high) {
            if (nums[low] % 2 == 0) {
                low++;
            } else if (nums[high] % 2 != 0) {
                high--;
            } else {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }

        System.out.println(Arrays.toString(arr) + "\n" + Arrays.toString(nums));
    }
}
