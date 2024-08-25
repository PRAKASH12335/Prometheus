package Misc;

import java.util.Arrays;

public class MicrosoftTest {

    private String solution(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=9;i++){
            sb.append(i);
            for(int j=0;j<=9;j++){
                if(j > i){
                    String num = i+""+j;
                    sb.append(num);
                }
            }
        }
        return sb.toString();
    }

    private int calculate(String s){
        int length = s.length();
        System.out.println(s);
        if(length > 100)
            return 0;
        int[] count = new int[100];
        for(int i=0;i<length-1;i++){
            int num = Integer.parseInt(s.substring(i, i+2));
            count[num] += 1;
        }
        for(int i=0;i<100;i++){
            System.out.println(i +" -> " +count[i]);
        }
        return Arrays.stream(count).sum();
    }

    // 0010203040506070809112131415161718192232425262728293343536373839445464748495565758596676869778798899

    public static void main(String[] args) {
        MicrosoftTest mt = new MicrosoftTest();
        String s = mt.solution();
        System.out.println(mt.calculate(s));
    }
}
