//GFG: https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
import java.util.*;
public class RemoveDuplicatesFromAnUnsortedLinkedList {
    public static Node removeDuplicates(Node head) {
        if(head == null) return null;
        Set<Integer> duplicate = new HashSet<>();
        Node current = head;
        Node previous = null;
        while(current != null){
            if(duplicate.contains(current.data)){
                previous.next = current.next;
            } else {
                duplicate.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node node = new Node(5);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(4);

        Node res = removeDuplicates(node);

        while (res != null) {
            System.out.print(res.data + "->");
            res = res.next;
        }
    }
}
