//LeetCode: https://practice.geeksforgeeks.org/problems/avl-tree-deletion/1
class AVLNode {
    int key, height;
    AVLNode left, right;
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}
public class AVLTreeDeletion {
     static AVLNode root;
    static int height(AVLNode node) {
        if (node == null) return 0;
        return node.height;
    }
    static int balanceFactor(AVLNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }
    static AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

     static AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    static AVLNode insert(AVLNode node, int key) {
        if (node == null) return new AVLNode(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node; // Duplicate keys are not allowed
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = balanceFactor(node);
        // Left Heavy
        if (balance > 1) {
            if (key < node.left.key) return rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        // Right Heavy
        if (balance < -1) {
            if (key > node.right.key) return rotateLeft(node);
            else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    static void insertKey(int key) {
        root = insert(root, key);
    }
    static void print() {
        printTree(root, 0, "Root: ");
    }
    public static AVLNode deleteNode(AVLNode node, int key) {
        if (node == null) return node;
        if (key < node.key) node.left = deleteNode(node.left, key);
        else if (key > node.key) node.right = deleteNode(node.right, key);
        else {
            if (node.left == null || node.right == null) {
                AVLNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                AVLNode temp = findMinValueNode(node.right);
                node.key = temp.key;
                node.right = deleteNode(node.right, temp.key);
            }
        }
        if (node == null) return node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);
        // Left Heavy
        if (balance > 1) {
            if (balanceFactor(node.left) >= 0) return rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        // Right Heavy
        if (balance < -1) {
            if (balanceFactor(node.right) <= 0) return rotateLeft(node);
            else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    static AVLNode findMinValueNode(AVLNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
    static void printTree(AVLNode node, int level, String prefix) {
        if (node != null) {
            System.out.println(" ".repeat(level * 4) + prefix + node.key);
            if (node.left != null || node.right != null) {
                printTree(node.left, level + 1, "L--- ");
                printTree(node.right, level + 1, "R--- ");
            }
        }
    }
    public static void main(String[] args) {
        int[] keys = { 4, 2, 1, 6, 3, 5, 7 };
        for (int key : keys) insertKey(key);
        int keyToDelete = 4;
        AVLNode result = deleteNode(root, keyToDelete);
        print();
    }
}
