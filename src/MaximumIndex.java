//GFG : https://practice.geeksforgeeks.org/problems/maximum-index3307/1
public class MaximumIndex {
    static int maxIndexDiff(int[] arr, int n){
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++)
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        rightMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--)
            rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        int maxDiff = -1, i = 0, j = 0;
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        int n = 9;
        int arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
//        int n = 2;
//        int arr[] = {18, 17};
        System.out.println(maxIndexDiff(arr, n));
    }
}
