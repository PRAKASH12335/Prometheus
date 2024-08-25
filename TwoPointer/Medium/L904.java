package TwoPointer.Medium;

// 904. Fruit Into Baskets

import java.util.HashMap;

public class L904 {

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int left = 0, right = 0, n = fruits.length, totalFruits = 0;
        while(right < n){
            hmap.put(fruits[right], hmap.getOrDefault(fruits[right], 0) +1);
            while(hmap.size() > 2){
                hmap.put(fruits[left], hmap.get(fruits[left]) - 1);
                if(hmap.get(fruits[left]) == 0){
                    hmap.remove(fruits[left]);
                }
                left++;
            }
            totalFruits = Math.max(totalFruits, right-left+1);
            right++;
        }
        return totalFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        L904 obj = new L904();
        System.out.println(obj.totalFruit(fruits));
    }
}


// Time complexity - O(N)
// Space complexity - O(N)