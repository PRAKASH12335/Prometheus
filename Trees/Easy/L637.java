package Trees.Easy;

// 637. Average of Levels in Binary Tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L637 {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.data;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            double avg = sum/size;
            ans.add(avg);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);

        System.out.println(averageOfLevels(t));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)