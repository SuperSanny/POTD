//LeetCode: https://leetcode.com/problems/all-possible-full-binary-trees/
import java.util.*;
public class AllPossibleFullBinaryTrees {
    private static Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<TreeNode>();
        if (n == 1) return Arrays.asList(new TreeNode());
        if (memo.containsKey(n)) return memo.get(n);
        List<TreeNode> res = new ArrayList<TreeNode>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(allPossibleFBT(n));
    }
}
