//Leetcode: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumDepthofBinaryTree {
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.right == null) return minDepth(root.left)+1;
        if(root.left == null) return minDepth(root.right)+1;
        return Math.min(minDepth(root.left), minDepth(root.right)) +1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        int minDepth = minDepth(root);
        System.out.println("Minimum Depth: " + minDepth);
    }
}
