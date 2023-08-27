//LeetCode: https://leetcode.com/problems/frog-jump/description/
import java.util.*;
public class FrogJump {
    public static boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], new HashSet<>());
        map.get(stones[0]).add(1);
        for(int i=0; i < stones.length; i++){
            int currStone = stones[i];
            HashSet<Integer> jumps = map.get(currStone);
            for(int jump: jumps){
                int pos = currStone + jump;
                if(pos == stones[stones.length - 1]) return true;
                if(map.containsKey(pos)){
                    if(jump - 1> 0) map.get(pos).add(jump - 1);
                    map.get(pos).add(jump);
                    map.get(pos).add(jump+1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}
