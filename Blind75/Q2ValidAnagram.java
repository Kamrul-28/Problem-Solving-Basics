package Blind75;

import java.util.*;

/**
 * Leetcode 242. Valid Anagram
 */
class Q2ValidAnagram {
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        boolean ans = isAnagram(s,t);
        System.out.println(ans);
    }

        /**
     * Solution Using HashMap
     * Time Complexity O(n)
     * Space Complexity O(n)
     */
    public static boolean isAnagram(String s,String t){
        if (s.length() != t.length()) return false;
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(Character c:s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }
        for(Character d:t.toCharArray()){
            tMap.put(d, tMap.getOrDefault(d, 0)+1);
        }
        return sMap.equals(tMap);
    }

    /**
     * Solution Using Array Sorting
     * Time Complexity O(nlogn)
     * Space Complexity O(1)
     */
    public static boolean isAnagram1(String s,String t){
        if (s.length() != t.length()) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
    
        return Arrays.equals(sCharArray,tCharArray);
    }
}
