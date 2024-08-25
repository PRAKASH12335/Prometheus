package Trees.Medium;

// 654. Maximum Binary Tree

public class L654 {

    public static void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static int findMax(int[] nums, int start, int end) {
        int max = nums[start], maxIndex = start;
        for(int i=start+1;i<=end;i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

        public static TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        int index = findMax(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, start, index-1);
        node.right = helper(nums, index+1, end);
        return node;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTree(nums);
        printTree(node);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)