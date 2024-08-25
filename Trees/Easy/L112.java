package Trees.Easy;

// 112. Path Sum

public class L112 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(targetSum == root.data && root.left == null && root.right == null )
            return true;
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(hasPathSum(node, targetSum));
    }
}


// Time Complexity - O(N)
// Space Complexity - O(H)