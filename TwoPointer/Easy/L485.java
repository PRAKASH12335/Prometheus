package TwoPointer.Easy;

//Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class L485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int countOnes = 0;
        int maxOnes = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                countOnes++;
                maxOnes = Math.max(maxOnes, countOnes);
            }else
                countOnes = 0;
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)