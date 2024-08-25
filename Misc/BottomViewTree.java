package Misc;

import java.util.*;

class Tuple{
    int line;
    TreeNode node;
    Tuple(int line, TreeNode node){
        this.line = line;
        this.node = node;
    }
}


public class BottomViewTree {

    public static List<Integer> bottomView(TreeNode root){
        Queue<Tuple> q = new LinkedList<>();
        Map<Integer, Integer> tmap = new TreeMap<>();
        q.add(new Tuple( 0, root));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int line = t.line;
            tmap.put(line, node.data);

            if(node.left != null){
                q.add(new Tuple(line-1, node.left));
            }
            if(t.node.right != null){
                q.add(new Tuple(line+1, node.right));
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
        System.out.println(bottomView(root));
    }
}
