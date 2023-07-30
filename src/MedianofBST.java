//GFG: https://practice.geeksforgeeks.org/problems/median-of-bst/1
import java.util.*;
public class MedianofBST {
    public static float findMedian(TreeNode root) {
        if (root == null)  return 0;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int len = list.size();
        if(len == 1) return list.get(0);
        float median = 0f;
        if(len%2 == 0){
            median += list.get(len/2);
            median += list.get(len/2 - 1);
            return median/2;
        }
        return list.get(len/2);
    }
    public static void inOrder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left != null) inOrder(node.left, list);
        list.add(node.val);
        if(node.right != null) inOrder(node.right, list);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        float ans = findMedian(root);
        System.out.println(ans);
    }
}
