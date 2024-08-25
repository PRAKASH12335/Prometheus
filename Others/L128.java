package Others;// 128. Longest Consecutive Sequence

import java.util.HashSet;

public class L128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int longestSequence = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int count = 1;
                int curr = nums[i];
                while(set.contains(curr+1)){
                    count++;
                    curr++;
                }
                longestSequence = Math.max(longestSequence, count);
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        L128 obj = new L128();
        System.out.println(obj.longestConsecutive(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)