package Trees.Medium;

import java.util.*;

public class L102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                level.add(temp.data);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            ans.add(level);
        }
        return ans;
    }

    // L103
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        boolean leftToRight = true;
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            if(leftToRight){
                for(int i=0;i<size;i++){
                    TreeNode temp = dq.pollFirst();
                    level.add(temp.data);
                    if(temp.left != null)
                        dq.addLast(temp.left);
                    if(temp.right != null)
                        dq.addLast(temp.right);
                }
            }else{
                for(int i=0;i<size;i++){
                    TreeNode temp = dq.pollLast();
                    level.add(temp.data);
                    if(temp.right != null)
                        dq.addFirst(temp.right);
                    if(temp.left != null)
                        dq.addFirst(temp.left);
                }
            }
            leftToRight = !leftToRight;
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        System.out.println(levelOrder(t));
        System.out.println(zigzagLevelOrder(t));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)