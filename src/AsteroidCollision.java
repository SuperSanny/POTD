//LeetCode: https://leetcode.com/problems/asteroid-collision/
import java.util.*;
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int asteroid : asteroids){
            boolean shouldAdd = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int topAsteroid = stack.peek();
                if(Math.abs(asteroid) > topAsteroid){
                    stack.pop();
                } else if(Math.abs(asteroid) == topAsteroid) {
                    stack.pop();
                    shouldAdd = false;
                    break;
                } else {
                    shouldAdd = false;
                    break;
                }
            }
            if(shouldAdd) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        int[] result = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }
}
