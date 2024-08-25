package Stack.Medium;

// 735. Asteroid Collision

import java.util.Arrays;
import java.util.Stack;

public class L735 {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0){
                if(Math.abs(st.peek()) == Math.abs(asteroids[i])){
                    st.pop();
                }else if(Math.abs(st.peek()) < Math.abs(asteroids[i])){
                    st.pop();
                    i--;
                }
            }else{
                st.push(asteroids[i]);
            }
        }
        int[] res = new int[st.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {-1, 3, 2, -3};
        int[] res = asteroidCollision(asteroids);
        Arrays.stream(res).forEach(a -> System.out.println(a));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)