//Leetcode : https://leetcode.com/problems/single-number-ii/
public class SingleNumber_II {
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            twos |= (ones & num);
            ones ^= num;
            int commonBits = ~(ones & twos);
            ones &= commonBits;
            twos &= commonBits;
        }
        return ones;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        int ans = singleNumber(nums);
        System.out.println(ans);
    }
}
