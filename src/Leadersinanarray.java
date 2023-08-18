//GFG: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
import java.util.*;
public class Leadersinanarray {
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<>();
        int max = arr[n-1];
        list.add(max);
        for(int i = n-2; i>= 0; i--){
            if(max <= arr[i]){
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0};
        int n = arr.length;
        System.out.println(leaders(arr,n));
    }
}
