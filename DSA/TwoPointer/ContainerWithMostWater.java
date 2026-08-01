public class ContainerWithMostWater {

    static int containerWithMostWater(int[] arr){
        int maxArea = Integer.MIN_VALUE;

        int l = 0 , r = arr.length-1;

        while(l<r){
            int currArea = (r-l) * Math.min(arr[l] , arr[r]);

            maxArea = Math.max(currArea , maxArea);

            if(arr[l] < arr[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = containerWithMostWater(height);
        System.out.println(maxArea);
    }
}
