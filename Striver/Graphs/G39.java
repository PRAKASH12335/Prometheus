package Striver.Graphs;

// G-39. Minimum Multiplications to Reach End

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuple{
    int node;
    int steps;
    Tuple(int node, int steps){
        this.node = node;
        this.steps = steps;
    }
}

public class G39 {

    public int minMultiplicationToReach(int start, int end, int[] arr){
        int mod = 100000;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(start, 0));
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int node = t.node;
            int steps = t.steps;
            for(int i : arr){
                int mul = (node * i)%mod;
                if(steps + 1 < dist[mul]){
                    dist[mul] = steps+1;
                    if(mul == end)
                        return dist[mul];
                    q.add(new Tuple(mul, steps+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int start = 3, end = 75;
        int[] arr = {2, 5, 7};
        G39 obj = new G39();
        System.out.println(obj.minMultiplicationToReach(start, end, arr));
    }
}

// Time Complexity - O(100000 * N)
// Space Complexity - O(100000 * N)