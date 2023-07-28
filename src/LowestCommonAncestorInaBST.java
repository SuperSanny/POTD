//GFG: https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
import java.util.*;
public class LowestCommonAncestorInaBST {

    static TreeNode LCA(TreeNode root, int n1, int n2) {
        if(root == null) return null;
        if(root.val == n1 || root.val == n2) return root;
        TreeNode left = LCA(root.left, n1, n2);
        TreeNode right = LCA(root.right, n1, n2);
        if(left != null && right != null) return root;
        else if (left != null) return left;
        else if(right != null) return right;
        else return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int n1 = 1, n2 = 3;
        System.out.println(LCA(root, n1, n2).val);
    }
}
