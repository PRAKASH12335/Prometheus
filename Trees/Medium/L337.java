package Trees.Medium;

import java.util.HashMap;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
}

public class L337 {

    //Memo
    static HashMap<TreeNode, Integer> hmap = new HashMap<>();
    public static int robMemo(TreeNode root) {
        if(root == null)
            return 0;
        if(hmap.containsKey(root))
            return hmap.get(root);
        int ans = 0;
        if(root.left != null)
            ans += rob(root.left.left)+rob(root.left.right);
        if(root.right != null)
            ans += rob(root.right.left)+rob(root.right.right);

        int res = Math.max(ans+root.data, rob(root.left)+rob(root.right));
        hmap.put(root, res);
        return res;
    }

    // Recursion
    public static int rob(TreeNode root) {
        if(root == null)
            return 0;
        int ans = 0;
        if(root.left != null)
            ans += rob(root.left.left)+rob(root.left.right);
        if(root.right != null)
            ans += rob(root.right.left)+rob(root.right.right);

        return Math.max(ans+root.data, rob(root.left)+rob(root.right));
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(2);
        t.left.right = new TreeNode(3);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(1);
        System.out.println(rob(t));
        System.out.println(robMemo(t));
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)