//LeetCode: https://leetcode.com/problems/sliding-window-maximum/
import java.util.*;
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);
        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
