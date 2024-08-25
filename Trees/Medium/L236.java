package Trees.Medium;

// 236. Lowest Common Ancestor of a Binary Tree

public class L236 {

    public static boolean findNode(TreeNode root, TreeNode node){
        if(root == null)
            return false;
        if(root.data == node.data)
            return true;
        if(root.left != null && findNode(root.left, node) || root.right != null && findNode(root.right, node))
            return true;
        return false;
    }

    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root.data == p.data || root.data == q.data)
            return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(left != null && right!=null)
            return root;
        return left != null ? left : right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(findNode(root, p) == false || findNode(root, q) == false)
            return null;
        return LCA(root, p, q);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);
        TreeNode ans = lowestCommonAncestor(t, t.left, t.left.right.right);
        System.out.println(ans.data);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(h)