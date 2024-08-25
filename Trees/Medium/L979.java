package Trees.Medium;

// 979. Distribute Coins in Binary Tree

public class L979 {

    static int coins;

    public static int coinsHelper(TreeNode root) {
        if(root == null) return 0;
        int left = coinsHelper(root.left);
        int right = coinsHelper(root.right);
        coins = coins + Math.abs(left) + Math.abs(right);
        return root.data + left + right - 1;
    }
    public static int distributeCoins(TreeNode root) {
        coins = 0;
        coinsHelper(root);
        return coins;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(3);
        t.right = new TreeNode(0);
        System.out.println(distributeCoins(t));
    }
}

