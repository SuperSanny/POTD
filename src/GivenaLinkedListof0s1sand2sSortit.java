//GFG: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class GivenaLinkedListof0s1sand2sSortit {
    static Node segregate(Node head) {
        int zero = 0, one = 0;
        Node curr = head;
        while (curr != null) {
            zero += (curr.data == 0) ? 1 : 0;
            one += (curr.data == 1) ? 1 : 0;
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (zero-- > 0) curr.data = 0;
            else if (one-- > 0) curr.data = 1;
            else curr.data = 2;
            curr = curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(2);
        node.next.next = new Node(0);
        node.next.next.next = new Node(1);
        Node res = segregate(node);
        while (res != null) {
            System.out.print(res.data + "->");
            res = res.next;
        }
    }
}
