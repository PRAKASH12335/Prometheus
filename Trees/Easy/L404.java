package Trees.Easy;

// 404. Sum of Left Leaves

public class L404 {

    static int sum = 0;
    public static void helper(TreeNode root, boolean isLeft) {
        if(root == null) return ;
        if(root.left == null && root.right == null && isLeft){
            sum += root.data;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)