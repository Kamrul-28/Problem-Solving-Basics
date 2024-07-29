package Blind75;
import java.util.HashMap;

/**
 * Leetcode 1. Two Sum
 */
class Q3TwoSum {
    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        Integer target = 9;
        for(int num:twoSum1(nums,target)){
            System.out.println(num);
        }
        
    }

    public static int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<nums.length;i++){
            Integer diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{i,map.get(diff)};
            }
            map.put(nums[i],i);

       }
       return new int[]{};
    }

    public static int[] twoSum1(int[] nums, int target) {
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]+nums[j-1] == target){
                    return new int[]{j,j-1};
                }
            }
        }

        return new int[]{};
     }
}