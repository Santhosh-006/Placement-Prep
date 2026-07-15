import java.util.Arrays;

public class RotateArray{

    public void reverse(int[] arr , int l , int r){
        for(int i=r/2; i>=l ; i--){
            int temp = arr[i];
            arr[i] = arr[r-i];
            arr[r-i] = temp;
        }
    }

    public static void main(String[] args) {

        RotateArray obj = new RotateArray();

        int[] arr = {1,2,3,4};
        obj.reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}