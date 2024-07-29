package Blind75;
/**
 * Leetcode 217. Contains Duplicate
 */

import java.util.*;

class Main{
    /**
     * @param args
     */
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        boolean ans = containsDuplicate(nums);
        System.out.println(ans);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer num:nums){
            if (set.contains(num)){
               return true; 
            }
            set.add(num);
        }
        return false;
    }
}