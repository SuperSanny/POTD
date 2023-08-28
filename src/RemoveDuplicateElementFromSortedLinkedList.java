//GFG: https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
import java.util.*;
public class RemoveDuplicateElementFromSortedLinkedList {
    static ListNode removeDuplicates(ListNode head)
    {
	    if(head == null) return head;
	    ListNode currNode = head;
	    while(currNode.next != null){
	        if(currNode.val == currNode.next.val) {
	            currNode.next = currNode.next.next;
	            continue;
	        }
	        currNode = currNode.next;
	    }
	    return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(2);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode head = removeDuplicates(root);
        while(head != null) {
            System.out.print(head.val + "->");
        }
    }
}
