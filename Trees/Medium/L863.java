package Trees.Medium;

import java.util.*;

// 863. All Nodes Distance K in Binary Tree

public class L863 {

    public static void createMap(TreeNode root, HashMap<TreeNode, TreeNode> parentsMap){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null) {
                    parentsMap.put(node.left, node);
                    q.add(node.left);
                }
                if(node.right != null) {
                    parentsMap.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentsMap = new HashMap<>();
        createMap(root, parentsMap);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        q.add(target);
        visited.put(target, true);

        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist == k) break;
            dist++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(parentsMap.get(node) != null && visited.get(parentsMap.get(node)) == null){
                    visited.put(parentsMap.get(node), true);
                    q.add(parentsMap.get(node));
                }
                if(node.left != null && visited.get(node.left) == null){
                    visited.put(node.left, true);
                    q.add(node.left);
                }
                if(node.right != null && visited.get(node.right) == null){
                    visited.put(node.right, true);
                    q.add(node.right);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().data);
        }
        return ans;
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
        int k = 2;

        System.out.println(distanceK(t, t.left, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)