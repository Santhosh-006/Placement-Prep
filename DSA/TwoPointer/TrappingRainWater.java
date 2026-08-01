public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int waterStored = trappedRainWater(height);
        System.out.println(waterStored);

    }

    static int trappedRainWater(int[] height){
        int n=height.length;
        int left = 0;
        int right = n-1;

        int lm=0;
        int rm=0;
        int water =0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=lm){
                    lm=height[left];
                }else{
                    water +=lm-height[left];
                }
                left++;
            }else {
                if(height[right]>=rm){
                    rm=height[right];
                }else{
                    water +=rm-height[right];
                }
                right--;
            }
        }

        return water;
    }

}
