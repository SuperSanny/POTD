//LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/
import java.util.*;
public class KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int num: nums){
            queue.offer(num);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }
}
