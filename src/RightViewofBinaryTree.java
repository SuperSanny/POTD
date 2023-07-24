//GFG: https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
import java.util.*;
public class RightViewofBinaryTree {
    static ArrayList<Integer> rightView(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode newNode = queue.poll();
                if (i == levelSize - 1) result.add(newNode.val);
                if (newNode.left != null) queue.add(newNode.left);
                if (newNode.right != null) queue.add(newNode.right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        ArrayList<Integer> list = rightView(root);
        System.out.println(list);

    }
}
