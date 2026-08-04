import java.lang.reflect.Array;
import java.util.Arrays;

public class AlternateSorting {

//    1) Alternate sorting: Given an array of integers, rearrange the array in such a way that the first element is first maximum and second element is first minimum.
//    Eg.) Input  : {1, 2, 3, 4, 5, 6, 7}
//    Output : {7, 1, 6, 2, 5, 3, 4}

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));

        alternateSorting(arr);

        System.out.println(Arrays.toString(arr));

    }

    static void alternateSorting(int[] arr){
        for(int i=0 ; i<arr.length/2;i++){

            int temp = arr[arr.length - 1];

            for(int j = arr.length-1 ; j>2*i ; j--){
                arr[j] = arr[j-1];
            }

            arr[2*i] = temp;
        }
    }

}
