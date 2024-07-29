package Blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q12ValidParentheses {
    public static boolean Solution1(String s){
        Stack<Character> stc = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');  

        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                if(!stc.isEmpty() && map.get(c).equals(stc.peek())){
                    stc.pop();
                }else{
                    return false;
                }
            }else{
                stc.push(c);
            }
        }

        return stc.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "[]()[{()}]";
        System.out.println(Solution1(s));
    }
}
