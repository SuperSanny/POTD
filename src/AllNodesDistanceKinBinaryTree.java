//LeetCode: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
import java.util.*;

public class AllNodesDistanceKinBinaryTree {
        static Map<TreeNode, Integer> map = new HashMap<>();

        public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> result = new LinkedList<>();
            find(root, target);
            dfs(root, target, k, map.get(root), result);
            return result;
        }

        static int find(TreeNode root, TreeNode target) {
            if (root == null) return -1;
            if (root == target) {
                map.put(root, 0);
                return 0;
            }
            int left = find(root.left, target);
            if (left >= 0) {
                map.put(root, left + 1);
                return left + 1;
            }
            int right = find(root.right, target);
            if (right >= 0) {
                map.put(root, right + 1);
                return right + 1;
            }
            return -1;
        }

        public static void dfs(TreeNode root, TreeNode target, int k, int length, List<Integer> result) {
            if (root == null) return;
            if (map.containsKey(root)) length = map.get(root);
            if (length == k) result.add(root.val);
            dfs(root.left, target, k, length + 1, result);
            dfs(root.right, target, k, length + 1, result);
        }
        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            TreeNode target = root.left;
            int k = 2;

            List<Integer> answer = distanceK(root, target, k);
            System.out.println(answer);
        }
}
