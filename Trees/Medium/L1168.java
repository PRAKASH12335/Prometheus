package Trees.Medium;

// 1161. Maximum Level Sum of a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class L1168 {

    public static int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int maxSum = Integer.MIN_VALUE, ans = 0;
        while(!q.isEmpty()){
            level++;
            int sumAtLevel = 0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sumAtLevel += node.data;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(maxSum < sumAtLevel){
                maxSum = sumAtLevel;
                ans = level;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(7);
        t.right = new TreeNode(0);
        t.left.left = new TreeNode(7);
        t.left.right = new TreeNode(-8);

        System.out.println(maxLevelSum(t));
    }
}
