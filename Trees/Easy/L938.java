package Trees.Easy;

import java.util.LinkedList;
import java.util.Queue;

// 938. Range Sum of BST
public class L938 {

    // DFS
    static int sumDfs = 0;

    public static void dfs(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.data > low)
            dfs(root.left, low, high);
        if(root.data >= low && root.data <= high )
            sumDfs += root.data;
        if(root.data < high)
            dfs(root.right, low, high);
    }

    public static int rangeSumBSTDFS(TreeNode root, int low, int high) {
        if(root == null) return 0;
        dfs(root, low, high);
        return sum;
    }

    // Time complexity: O(n)
    // Space complexity: O(h)

    // BFS
    static int sum = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.data >= low && node.data <= high)
                    sum += node.data;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return sum;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)

    public static void main(String[] args) {
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(5);
        t.right = new TreeNode(15);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(7);
        t.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(t, 7, 15));
        System.out.println(rangeSumBSTDFS(t, 7, 15));
    }
}
