//LeetCode: https://leetcode.com/problems/search-a-2d-matrix/
public class Searcha2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i < matrix.length; i++){
            if(search(matrix[i], target)) return true;
        }
        return false;
    }
    public static boolean search(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start + (end - start ) / 2;
            if (target < arr[mid]){
                end  = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
