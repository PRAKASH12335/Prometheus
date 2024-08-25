package Trees.Easy;

// 572. Subtree of Another Tree

public class L572 {

    public static boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        if(root.data == subRoot.data && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right))
            return true;
        return false;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(isSame(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) ||  isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);

        TreeNode node2 = new TreeNode(4);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(2);
        System.out.println(isSubtree(node, node2));
    }
}

// Time Complexity - O(M*N)  where M = nodes in tree and N = nodes in subtree
// Space Complexity - O(H)