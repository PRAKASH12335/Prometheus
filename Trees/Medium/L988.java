package Trees.Medium;

// 988. Smallest String Starting From Leaf

class TreeChar{
    char c;
    TreeChar left;
    TreeChar right;
    TreeChar(char c){
        this.c = c;
    }
}

public class L988 {

    static String ans = "~";
    public static void dfs(TreeChar root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.c);
        if(root.left == null && root.right == null){
            sb.reverse();
            String str = sb.toString();
            sb.reverse();
            if(ans.compareTo(str) > 0)
                ans = str;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public static String smallestFromLeaf(TreeChar root) {
        dfs(root, new StringBuilder());
        return ans;
    }


    public static void dfs(TreeChar root, String sb){
        if(root == null) return;
        sb = sb+root.c;
        if(root.left == null && root.right == null){
            StringBuilder str = new StringBuilder(sb);
            str.reverse();
            String st = str.toString();
            sb = str.reverse().toString();
            if(ans.compareTo(st) > 0)
                ans = st;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        System.out.println(sb);
//        sb.deleteCharAt(sb.length()-1);
    }

    public static String smallestFromLeafAnother(TreeChar root) {
        dfs(root, "");
        return ans;
    }

    public static void main(String[] args) {
        TreeChar t = new TreeChar('a');
        t.left = new TreeChar('b');
        t.right = new TreeChar('c');
        t.left.left = new TreeChar('d');
        t.left.right = new TreeChar('e');
        t.right.left = new TreeChar('d');
        t.right.right = new TreeChar('e');

        System.out.println(smallestFromLeaf(t));

        System.out.println(smallestFromLeafAnother(t));
    }
}
