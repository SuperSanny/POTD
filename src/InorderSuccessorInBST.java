//GFG: https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1

public class InorderSuccessorInBST {
    public static TreeNode inorderSuccessor(TreeNode root,TreeNode x) {
        TreeNode successor = null;
        while (root != null) {
            if(root.val > x.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode x = root;
        TreeNode ans = inorderSuccessor(root, x);
        System.out.println(ans.val);
    }
}
