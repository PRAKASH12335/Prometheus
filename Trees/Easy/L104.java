package Trees.Easy;

// 104. Maximum Depth of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class L104 {

    // BFS
    private static int levelOrder(TreeNode root){
        if( root == null ){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while( queue.size() > 0 ){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode remNode = queue.remove();
                if( remNode.left != null ){
                    queue.add( remNode.left );
                }
                if( remNode.right != null ){
                    queue.add( remNode.right );
                }
            }
            level++;
        }
        return level;
    }

    // DFS
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
//        int lh = maxDepth(root.left);
//        int rh = maxDepth(root.right);
//        return lh+1 > rh+1 ? lh+1 : rh+1;

        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(maxDepth(node));
        System.out.println(levelOrder(node));
    }
}

// BFS
// Time Complexity - O(N)
// Space Complexity - O(N)

// DFS
// Time Complexity - O(N)
// Space Complexity - O(1) Extra Space + O(H) Recursion Stack space, where “H”  is the height of the binary tree.