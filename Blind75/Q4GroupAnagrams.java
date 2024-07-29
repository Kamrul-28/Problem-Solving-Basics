package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 4_49_Group_Anagrams
 */
public class Q4GroupAnagrams {
    public static void main(String[] args){
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
     
    }

     public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString =  new String(charArray);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>(){});
            }
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
     }
}
