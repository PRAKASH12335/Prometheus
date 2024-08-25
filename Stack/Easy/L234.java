package Stack.Easy;

// 234. Palindrome Linked List

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }
}

public class L234 {

    static ListNode left;
    public static boolean isPalindromeHelper(ListNode right) {
        if(right == null) return true;
        boolean isp = isPalindromeHelper(right.next);
        if(isp == false)
            return false;
        boolean isp1 = left.data == right.data ? true : false;
        left = left.next;
        return isp1;
    }

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return isPalindromeHelper(head);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(root));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)