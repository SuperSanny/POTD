//GFG: https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
import java.util.*;
public class ImplementTwoStacksInAnArray {
    class twoStacks
    {
        //Function to push an integer into the stack1.
        List<Integer> stack1 = new ArrayList<>();
        List<Integer> stack2 = new ArrayList<>();
        void push1(int x)
        {
            stack1.add(x);
        }
        //Function to push an integer into the stack2.
        void push2(int x)
        {
            stack2.add(x);
        }
        //Function to remove an element from top of the stack1.
        int pop1()
        {
            if(stack1.size() == 0) return -1;
            return stack1.remove(stack1.size() - 1);
        }
        //Function to remove an element from top of the stack2.
        int pop2()
        {
            if (stack2.size() == 0) return -1;
            else return stack2.remove(stack2.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
