package Misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// Minimum time taken to BURN the Binary Tree from a Node

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data =data;
    }
}

public class TimeTakenToBurnTree {
    public static TreeNode createMap(TreeNode root, HashMap<TreeNode, TreeNode> parentMap, TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode res = null;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.data == node.data)
                res = curr;
            if(curr.left != null){
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return res;
    }

    public static int timeToBurnTree(TreeNode root, TreeNode node){
        if(root == null)
            return 0;
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode target = createMap(root, parentMap, node);

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        q.add(target);
        visited.put(target, true);

        int minTime =0;
        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(parentMap.get(curr) != null && visited.get(parentMap.get(curr)) == null){
                    flag = 1;
                    visited.put(parentMap.get(curr) , true);
                    q.add(parentMap.get(curr));
                }
                if(curr.left != null && visited.get(curr.left) == null){
                    flag = 1;
                    visited.put(curr.left , true);
                    q.add(curr.left);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    flag = 1;
                    visited.put(curr.right , true);
                    q.add(curr.right);
                }
            }
            if(flag == 1)
                minTime++;
        }
        return minTime;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);

        System.out.println(timeToBurnTree(t, t.left.right));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)