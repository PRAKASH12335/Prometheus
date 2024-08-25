package LinkedList.Easy;

// 206. Reverse a Linked List

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }
}

public class L206 {

    public static ListNode reverse(ListNode head){
        if(head == null)
            return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextt = null;
        while(curr != null){
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(7);

        ListNode result = reverse(l1);
        while(result.next != null){
            System.out.print(result.data + "->");
            result = result.next;
        }
        System.out.print(result.data);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)