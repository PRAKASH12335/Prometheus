package Others;

// 645.Set Mismatch

public class L645 {

    public static int[] setMismatch(int[] nums){
        int[] ans = new int[2];
        for(int i=0;i< nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                ans[0] = index+1;
            }else{
                nums[index] = - nums[index];
            }
        }

        for(int i=0;i< nums.length;i++) {
            if (nums[i] > 0){
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] result = setMismatch(nums);
        System.out.println(result[0] + " " + result[1]);
    }
}


// Space Complexity - O(N)
// Time complexity - O(1)