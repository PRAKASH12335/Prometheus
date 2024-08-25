package Misc;

// Design a data structure that supports insert, delete, search and getRandom in constant time

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class OperationsInConstantTime {

    List<Integer> arr;
    HashMap<Integer, Integer> hmap;
    OperationsInConstantTime(){
        arr = new ArrayList<>();
        hmap = new HashMap<>();
    }

    public void add(int x){
        if(!hmap.containsKey(x)){
            int index = arr.size();
            arr.add(x);
            hmap.put(x, index);
        }
    }

    public int search(int x){
        if(hmap.containsKey(x)){
            return hmap.get(x);
        }
        return -1;
    }

    public int getRandom(){
        Random random = new Random();
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }

    public void remove(int x){
        if(hmap.containsKey(x)){
            int index = hmap.get(x);
            int lastIndex = arr.size()-1;
            arr.set(index, arr.get(lastIndex));
            hmap.put(arr.get(lastIndex), index);
            hmap.remove(x);
            arr.remove(lastIndex);
        }
    }

    public static void main(String[] args) {
        OperationsInConstantTime oct = new OperationsInConstantTime();
        oct.add(10);
        oct.add(20);
        oct.add(30);
        oct.add(40);
        System.out.println(oct.search(30)); // Output: 2
        oct.remove(20);
        oct.add(50);
        System.out.println(oct.search(50)); // Output: 3
        System.out.println(oct.getRandom());
    }
}

// Space Complexity - O(1)
// Time complexity - O(N)