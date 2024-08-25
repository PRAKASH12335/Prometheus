package Trees.Hard;

import java.util.*;

//    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
class Point{
    int x;
    int y;
    int val;
    Point(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class L987 {
    public static void listUtil(List<Point> list, int x, int y, TreeNode root){
        if(root == null)
            return;
        list.add(new Point(x, y, root.data));
        listUtil(list, x-1, y-1, root.left);
        listUtil(list, x+1, y-1, root.right);
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Point> list = new ArrayList<>();
        listUtil(list, 0, 0, root);

        Collections.sort(list, (a,b) -> a.x == b.x ? a.y == b.y ? a.val - b.val : b.y - a.y : a.x - b.x);
        Map<Integer, List<Integer>> tmap = new TreeMap<>();
        for(Point p : list){
            List<Integer> line = tmap.getOrDefault(p.x, new ArrayList<>());
            line.add(p.val);
            tmap.put(p.x, line);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(tmap.values());
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        List<List<Integer>> ans = verticalTraversal(t);
        System.out.println(ans);
    }
}


// Time complexity - O(NlogN)
// Space complexity - O(N)