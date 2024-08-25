package LinkedList.Easy;

// 876. Middle of the Linked List

public class L876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        L876 obj = new L876();
        ListNode result = obj.middleNode(l1);
        while(result != null){
            System.out.println(result.data);
            result = result.next;
        }
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)