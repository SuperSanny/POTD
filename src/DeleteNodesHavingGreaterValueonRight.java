//GFG: https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
import java.util.*;
public class DeleteNodesHavingGreaterValueonRight {
    static ListNode compute(ListNode head) {
        head = reverse(head);
        ListNode newNode = head;
        while(newNode != null && newNode.next != null) {
            if(newNode.val > newNode.next.val) newNode.next = newNode.next.next;
            else newNode = newNode.next;
        }
        return reverse(head);
    }
    static ListNode reverse(ListNode head){
        ListNode prev = null, next = null;
        while(head!= null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode( 11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode newNode = compute(head);
        while(newNode != null) {
            System.out.print(newNode.val + "->");
            newNode = newNode.next;
        }
        System.out.print("null");
    }
}
