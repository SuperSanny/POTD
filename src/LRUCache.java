//LeetCode: https://leetcode.com/problems/lru-cache/description/
import java.util.*;
public class LRUCache {
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
        node.prev = head;
    }

    private class Node {
        Node next, prev;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
