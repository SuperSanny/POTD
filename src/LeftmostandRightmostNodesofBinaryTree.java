//GFG: https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1
import java.util.*;
public class LeftmostandRightmostNodesofBinaryTree {
    public static void printCorner(TreeNode node) {
        if(node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if(i == 0 || i == levelSize - 1) System.out.print(curr.val + " ");
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
    }
//    public static void printBinaryTree(TreeNode node, int level) {
//        if (node == null) return;
//        for (int i = 0; i < level; i++) System.out.print("|-----");
//        System.out.println(node.val);
//        printBinaryTree(node.left, level + 1);
//        printBinaryTree(node.right, level + 1);
//    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        printCorner(root);
//        printBinaryTree(root, 0);
    }
}
