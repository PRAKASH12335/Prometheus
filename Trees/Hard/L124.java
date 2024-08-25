package Trees.Hard;

// 124. Binary Tree Maximum Path Sum

class Res{
    int val;
}

public class L124 {

    public static int maxPathSumHelper(TreeNode root, Res res) {
        if(root == null) return 0;
        int left = maxPathSumHelper(root.left, res);
        int right = maxPathSumHelper(root.right, res);
        int temp = Math.max(root.data + Math.max(left, right), root.data);
        int ans =  Math.max(temp, left+right+root.data);
        res.val = Math.max(res.val, ans);
        return temp;
    }

    public static int maxPathSum(TreeNode root) {
        Res res= new Res();
        res.val=Integer.MIN_VALUE;
        maxPathSumHelper(root, res);
        return res.val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(maxPathSum(node));
    }
}

// Time Complexity - O(n)
// Time Complexity - O(h)