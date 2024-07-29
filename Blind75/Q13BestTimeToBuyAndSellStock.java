package Blind75;

// Solution 1
public class Q13BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] nums){
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[left]<nums[right]){
                maxProfit = Math.max(maxProfit, nums[right] - nums[left]);
            }else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static int Solution2(int[] nums){
        int buy = nums[0];
        int maxProfit = 0;

        for(int i = 1;i<nums.length ; i++){
            if(nums[i]<buy){
                buy = nums[i];
            }else{
                int sell = nums[i] - buy;
                maxProfit = Math.max(maxProfit, sell);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        int ans1 = maxProfit(nums);
        int ans2 = Solution2(nums);
        System.out.println("Maximum profit Solution 1: "+ans1);
        System.out.println("Maximum profit Solution 2: "+ans2);
    }
}
