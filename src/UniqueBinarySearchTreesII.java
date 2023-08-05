//LeetCode: https://leetcode.com/problems/unique-binary-search-trees-ii/
import java.util.*;
public class UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateUniqueTree(1, n);
    }
    public static List<TreeNode> generateUniqueTree(int start, int end){
        List<TreeNode> trees = new ArrayList<>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateUniqueTree(start, i-1);
            List<TreeNode> rightSubtrees = generateUniqueTree(i+1, end);
            for(TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubtree;
                    root.right = rightSubtree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateTrees(n));
    }
}
