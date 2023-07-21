//GFG: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

class Node
{
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}
public class ReverseaLinkedListInGroupsofGivenSize {
    public static Node reverse(Node node, int k) {
        if (node == null) return null;
        Node prev = null, temp = node, pointer = node;
        int i=0;
        while(i++ < k && pointer != null) {
            pointer = pointer.next;
            temp.next = prev;
            prev = temp;
            temp = pointer;
        }
        node.next = reverse(temp, k);
        return prev;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node res = reverse(node, 3);

        while (res != null) {
            System.out.print(res.data + "->");
            res = res.next;
        }
    }
}
