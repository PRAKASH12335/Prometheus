package Stack.Medium;

import java.util.Stack;

// 1209. Remove All Adjacent Duplicates in String II

public class L1209 {

    public static String removeDuplicates(String s, int k) {
        Stack<Character> charSt = new Stack<>();
        Stack<Integer> countSt = new Stack<>();

        int count = 0;
        for(char c : s.toCharArray()){
            if(!charSt.isEmpty() && charSt.peek() == c){
                countSt.push(countSt.pop()+1);
            }else if(!charSt.isEmpty() && charSt.peek() != c){
                count = 0;
            }
            if(count == 0){
                count++;
                countSt.push(count);
                charSt.push(c);
            }
            if(!charSt.isEmpty() && countSt.peek() == k){
                countSt.pop();
                charSt.pop();
            }
            if(charSt.isEmpty()){
                count = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!charSt.isEmpty()){
            int freq = countSt.pop();
            char c = charSt.pop();
            while(freq-->0){
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)