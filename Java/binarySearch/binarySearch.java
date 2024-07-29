public class binarySearch {
    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            if (nums[mid] <= target) {
                left = mid + 1;
            }else{
                right = mid-1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{10,20,30,40,50,60,70,80,90};
        int target = 80;
        System.out.println(search(nums,target));
        
    }
}
