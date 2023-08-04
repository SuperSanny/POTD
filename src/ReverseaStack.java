//GFG: https://practice.geeksforgeeks.org/problems/reverse-a-stack/1
import java.util.*;
public class ReverseaStack {
    static void reverse(Stack<Integer> s)
    {
        //Simple approach
//        if(s.isEmpty()) return;
//        Collections.reverse(s);
        // Another approach
        Stack<Integer> stack = new Stack<>();
        while (!s.isEmpty()) {
            stack.push(s.pop());
        }
        s = stack;
        System.out.println(s);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        reverse(stack);
    }
}
