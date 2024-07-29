package Blind75;

public class Q17FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left] <= nums[right]){
                return nums[left];
            }

            int mid = (left+right)/2;
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,0};
        System.out.println("Minimum Number: "+findMin(nums));
    }
}
