package Heap.Hard;

// 23. Merge k Sorted Lists

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class CustomComparator implements Comparator<ListNode>{
    @Override
    public int compare(ListNode l1, ListNode l2){
        return l1.val - l2.val;
    }
}

public class L23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(k,new CustomComparator());
        for(int i=0;i<k;i++){
            if(lists[i] != null)
                minPQ.add(lists[i]);
        }
        ListNode start = new ListNode(0);
        ListNode dummy = start;

        while(!minPQ.isEmpty()) {
            ListNode temp = minPQ.poll();
            dummy.next = temp;
            dummy = dummy.next;
            if (temp.next != null) {
                minPQ.add(temp.next);
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode result = mergeKLists(lists);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

// Time Complexity - O(NlogK)
// Space Complexity - O(K)
