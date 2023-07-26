//GFG: https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
import java.util.*;
public class KthAncestorinaTree {

    public static int kthAncestor(TreeNode root, int k, int node) {
        int[] ans = new int[]{-1};
        dfs(root, node, k, ans);
        return ans[0];
    }
    public static int dfs(TreeNode root, int node, int k, int[] ans) {
        if (root == null) return 0;
        if (root.val == node) return 1;
        int lf = dfs(root.left, node, k, ans);
        int rf = dfs(root.right, node, k, ans);
        if (lf == k || rf == k) ans[0] = root.val;
        if (lf != 0) return lf + 1;
        else if (rf != 0) return rf + 1;
        else return 0;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int K = 2, node = 4;
        System.out.println(kthAncestor(root, K, node));
    }
}
