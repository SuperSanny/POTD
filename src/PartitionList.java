//LeetCode: https://leetcode.com/problems/partition-list/
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftTail = left;
        ListNode rightTail = right;
        while(head != null) {
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode list = partition(l1, x);
        // Print the result
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
