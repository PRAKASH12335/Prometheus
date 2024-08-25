package Trees.Easy;

// 687. Longest Univalue Path

public class L687 {
    static int ans = 0;

    public static int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        if(root.left != null && root.data == root.left.data)
            left += 1;
        else
            left = 0;

        int right = helper(root.right);
        if(root.right != null && root.data == root.right.data)
            right += 1;
        else
            right = 0;

        ans = Math.max(ans, left+right);
        return Math.max(left, right);
    }

    public static int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(1);
        t.right.right = new TreeNode(5);

        System.out.println(longestUnivaluePath(t));
    }
}
