//GFG: https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
import java.util.*;
public class LevelOrderTraversalInSpiralForm {
    static ArrayList<Integer> findSpiral(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (level % 2 == 1) {
                result.addAll(currentLevel);
            } else {
                Collections.reverse(currentLevel);
                result.addAll(currentLevel);}
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        List<Integer> result = findSpiral(root);
        System.out.println(result);
    }
}
