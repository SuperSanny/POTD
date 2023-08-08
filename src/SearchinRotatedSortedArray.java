import java.util.stream.IntStream;

//LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
//        for(int i=0; i<nums.length; i++){
//            if(target == nums[i])
//                return i;
//        }
//        return -1;
        return IntStream.range(0, nums.length).filter(i -> nums[i] == target).findFirst().orElse(-1);
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
