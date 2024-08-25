package Trees.Easy;

// 108. Convert Sorted Array to Binary Search Tree

public class L108 {
    public static void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode helper(int[] nums, int start, int end){
        if(start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid-1);
        node.right = helper(nums, mid+1, end);
        return node;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        printTree(root);
    }
}
