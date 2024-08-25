package Trees.Medium;

// 662. Maximum Width of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}

public class L662 {

    public static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root, 0));
        int first = 0, last = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int num = p.num-mmin;
                if(i==0) first = num;
                if(i==size-1) last = num;
                if(node.left != null){
                    q.add(new Pair(node.left, 2*num+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, 2*num+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        System.out.println(widthOfBinaryTree(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)