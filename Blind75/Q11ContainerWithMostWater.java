package Blind75;

public class Q11ContainerWithMostWater {
    
    public static int Solution1(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int response = 0;
        while(left<right){
            int containerLength = right-left;
            int area = containerLength*Math.min(nums[left], nums[right]);
            response = Math.max(response, area);
            if(nums[left]<nums[right]){
                left++;
            }else{
                right--;
            }
        }
        return response;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int ans = Solution1(nums);
        System.out.println("Output: "+ans);
    }
}
