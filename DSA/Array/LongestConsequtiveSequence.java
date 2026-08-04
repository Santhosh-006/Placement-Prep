import java.util.HashSet;

public class LongestConsequtiveSequence {



    static int longestConsecutive(int[] nums) {
//        This approach uses only primitive and suitable only if the values in the array is small
        if(nums.length == 0) return 0;

        int max = max(nums);
        int min = min(nums);

        int[] hash = new int[max-min + 1];

        for(int num : nums){
            hash[num - min]++;
        }
        int maxCount = 0;
        int count = 0;

        for(int h : hash){
            if(h > 0){
                count++;
            }else{
                maxCount = Math.max(count , maxCount);
                count = 0;
            }
        }

        maxCount = Math.max(count , maxCount);

        return maxCount;
    }

    static int min(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < min){
                min = num;
            }
        }

        return min;
    }

    static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(max < num){
                max = num;
            }
        }

        return max;
    }

    static int longestSequenceUsingSet(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0;

        for(int num: nums){
            set.add(num);
        }

        for(int num:set){

            if(!set.contains(num-1)){

                int count = 1;
                int current = num;

                while(set.contains(current+1)){
                    current++;
                    count++;
                }

                maxCount = Math.max(count , maxCount);

            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(nums));
        System.out.println(longestSequenceUsingSet(nums));
    }
}
