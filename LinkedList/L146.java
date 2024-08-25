package LinkedList;// 146. LRU cache

import java.util.HashMap;

public class L146 {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
    }
    int cacheCapacity;
    Node head = new Node();
    Node tail = new Node();
    HashMap<Integer, Node> hmap;
    L146(int capacity){
        cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
        hmap = new HashMap<>();
    }
    public void remove(Node node){
        Node temp_next = node.next;
        Node temp_prev = node.prev;
        temp_prev.next = temp_next;
        temp_next.prev = temp_prev;
    }

    public void add(Node node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public int get(int key) {
        int value = -1;
        if(hmap.containsKey(key)){
            Node node = hmap.get(key);
            value = node.value;
            remove(node);
            add(node);
        }
        return value;
    }

    public void put(int key, int value) {
        Node node = hmap.get(key);
        if(node != null){
            remove(node);
            node.value = value;
            add(node);
        }else{
            if(hmap.size() == cacheCapacity){
                hmap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node temp = new Node();
            temp.key = key;
            temp.value = value;
            add(temp);
            hmap.put(key, temp);
        }
    }


    public static void main(String[] args) {
        L146 lRUCache = new L146(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}


// Time Complexity - O(1)
// Space Complexity - O(Capacity)