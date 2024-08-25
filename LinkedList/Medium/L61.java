package LinkedList.Medium;

// 61. Rotate List

public class L61 {

    private int length(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len = length(head);
        if(len == 0)
            return head;
        ListNode first = head;
        ListNode second = head;
        k = k%len;
        if(k == 0)
            return head;
        for(int i=0;i<k;i++){
            first = first.next;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        // s         f
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        //           s         f
        ListNode result = second.next;
        first.next = head;
        second.next = null;
        // 4 ->  5 -> 1 -> 2 -> 3 -> NULL
        //       f  head        s
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;

        L61 obj = new L61();
        ListNode result = obj.rotateRight(head, k);

        while(result.next != null){
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.print(result.data);
    }
}
