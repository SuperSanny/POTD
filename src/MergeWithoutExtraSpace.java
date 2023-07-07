import java.util.Arrays;

//GFG : https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
public class MergeWithoutExtraSpace {
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        int i = n-1, j = 0, k = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    public static void main(String[] args) {
        long[] arr1 = {1, 3, 5, 7};
        long[] arr2 = {0, 2, 6, 8, 9};
        merge(arr1, arr2, arr1.length, arr2.length);
        StringBuffer str = new StringBuffer();
        for(int i=0; i<arr1.length; i++){
            str.append(arr1[i]+" ");
        }
        for(int i=0; i<arr2.length; i++){
            str.append(arr2[i]+" ");
        }
        System.out.println(str);
    }
}
