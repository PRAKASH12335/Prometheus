package Misc;

import java.util.*;

class Pair{
    int hc;
    TreeNode node;
    Pair(int hc, TreeNode node){
        this.hc = hc;
        this.node = node;
    }
}

public class TopViewTree {

    public static List<Integer> topView(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> tmap = new TreeMap<>();
        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(!tmap.containsKey(p.hc)){
                tmap.put(p.hc, p.node.data);
            }
            if(p.node.left != null){
                q.add(new Pair(p.hc-1, p.node.left));
            }
            if(p.node.right != null){
                q.add(new Pair(p.hc+1, p.node.right));
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : tmap.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        System.out.println(topView(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)
