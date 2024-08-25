package Others;

// 169. Majority Element

public class L169 {

    public int majorityElement(int[] nums) {
        int count = 0, num = 0;
        for(int i=0;i< nums.length;i++){
            if(count == 0){
                num = nums[i];
                count++;
            }else{
                count += num == nums[i] ? 1 : -1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        L169 obj = new L169();
        System.out.println(obj.majorityElement(nums));
    }
}

// Space Complexity - O(N)
// Time complexity - O(1)