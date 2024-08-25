package Trees.Medium;

// 2265. Count Nodes Equal to Average of Subtree

class CountSum{
    int count;
    int sum;
    CountSum(int count, int sum){
        this.count = count;
        this.sum = sum;
    }
}

public class L2265 {

    static int ans = 0;

    public static CountSum helper(TreeNode root) {
        if(root == null)
            return new CountSum(0, 0);
        CountSum left = helper(root.left);
        CountSum right = helper(root.right);
        int count = 1 + left.count + right.count;
        int sum = root.data + left.sum + right.sum;
        if(sum/count == root.data)
            ans++;
        return new CountSum(count, sum);
    }
    public static int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(8);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(1);
        t.right.right = new TreeNode(6);

        System.out.println(averageOfSubtree(t));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)