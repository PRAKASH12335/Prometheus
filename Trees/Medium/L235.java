package Trees.Medium;

// 235. Lowest Common Ancestor of a Binary Search Tree

public class L235 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.data > p.data && root.data > q.data)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.data < p.data && root.data < q.data)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(7);
        t.left = new TreeNode(5);
        t.right = new TreeNode(10);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(6);

        TreeNode ans = lowestCommonAncestor(t, t.left.left, t.left.right);
        System.out.println(ans.data);
    }
}

// Time Complexity - O(h)
// Space Complexity - O(h)