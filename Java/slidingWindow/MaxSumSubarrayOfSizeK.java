package Java.slidingWindow;

public class MaxSumSubarrayOfSizeK {

    public static int maxSubArraySum(int[] nums,int k){
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for(int i=0;i<k;i++){
            windowSum += nums[i];

        }

        for(int i=k;i<nums.length;i++){
            windowSum += nums[i] - nums[i-k];
            maxSum = Math.max(windowSum,maxSum);
        }

        return maxSum;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,1,5,1,3,2};
        int k = 3;
        int result = maxSubArraySum(nums,k);
        System.out.println("Max Subarray Sum: "+ result);
    }
}
