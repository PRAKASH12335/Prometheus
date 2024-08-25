package Trees.Easy;

// 111. Minimum Depth of Binary Tree

public class L111 {

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return 1;
        int ls = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rs = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;;
        return Math.min(ls, rs)+1;
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
        System.out.println(minDepth(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)