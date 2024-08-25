package Others;

// 380. Insert Delete GetRandom O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class L380 {

    List<Integer> arr;
    HashMap<Integer, Integer> hmap;
    public L380() {
        arr = new ArrayList<>();
        hmap = new HashMap<>();
    }

    public boolean insert(int val) {
        if(hmap.containsKey(val))
            return false;
        int index = arr.size();
        hmap.put(val, index);
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!hmap.containsKey(val))
            return false;
        int index = hmap.get(val);
        int lastIndex = arr.size()-1;
        arr.set(index, arr.get(lastIndex));
        hmap.put(arr.get(lastIndex), index);
        arr.remove(lastIndex);
        hmap.remove(val);
        return true;
    }

    public int getRandom() {
        if(arr.size() == 0)
            return 0;
        Random random = new Random();
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }

    public static void main(String[] args) {
        L380 obj = new L380();
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        //System.out.println(oct.search(30)); // Output: 2
        obj.remove(20);
        obj.insert(50);
        //System.out.println(oct.search(50)); // Output: 3
        System.out.println(obj.getRandom());
    }
}
// Space Complexity - O(1)
// Time complexity - O(N)