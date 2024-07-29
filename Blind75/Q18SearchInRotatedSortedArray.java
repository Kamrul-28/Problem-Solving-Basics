package Blind75;

public class Q18SearchInRotatedSortedArray {
    public static int SearchInRotatedSortedArray(int[] nums,int target){
        int left=0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left]<=nums[mid]){
                if( target > nums[mid]   || target < nums[left] ){
                    left = mid +1;
                }else{
                    right = mid-1;
                }
            }else{
                if(target < nums[mid] || target > nums[right]){
                    left = mid +1;
                }else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,0,1,2};
        int target = 4;
        System.out.println("Output: "+SearchInRotatedSortedArray(nums,target));
    }
}