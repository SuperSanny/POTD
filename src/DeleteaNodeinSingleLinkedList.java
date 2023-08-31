//GFG: https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
public class DeleteaNodeinSingleLinkedList {
    static ListNode deleteNode(ListNode head, int x) {
        if(x == 1) head = head.next;
        ListNode currNode = head;
        int count = 0;
        while(currNode != null) {
            if(++count == x-1) {
                currNode.next = currNode.next.next;
                break;
            }
            currNode = currNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        int x = 1;
        ListNode ans = deleteNode(head, x);
        ListNode obj = new ListNode();
        obj.printListNode(ans);
    }
}
