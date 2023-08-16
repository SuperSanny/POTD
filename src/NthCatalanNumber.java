//GFG: https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1
public class NthCatalanNumber {
    public static int findCatalan(int n) {
        int mod = (int)(1e9+7);
        long[] arr = new long[n+1];
        arr[0] = 1L;
        arr[1] = 1L;
        for(int i=2; i<=n; i++)
            for(int j=0; j<i; j++)
                arr[i] = (arr[i] + arr[j] * arr[i-j-1])%mod;

        return (int)arr[n];
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(findCatalan(N));
    }
}
