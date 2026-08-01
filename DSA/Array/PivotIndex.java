public class PivotIndex {

    public static void main(String[] args) {

    }

    static int findPivotIndex(int[] arr){
        int totalSum = 0;
        for(int num : arr){
            totalSum+= num;
        }

        int rightSum = 0;
        int leftSum = 0;
        for(int num : arr){
            rightSum = totalSum - num - leftSum;
            if(rightSum == leftSum){
                return num;
            }
            leftSum += num;

        }

        return -1;
    }

}
