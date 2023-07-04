//GFG : https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1
public class Count_the_subarrays_having_product_less_than_k {
    public static int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int start = 0, count = 0;
        long product = 1;
        for (int i = 0; i < n; i++){
            product *= a[i];
            while(product >= k && start < n){
                product /= a[start];
                start++;
            }
            if(product < k){
                count += i - start + 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 4, k =10;
        long arr[] = {1,2,3,4};
        int ans = countSubArrayProductLessThanK(arr, n, k);
        System.out.println(ans);
    }
}
