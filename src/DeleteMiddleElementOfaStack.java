//GFG: https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

import java.util.*;
public class DeleteMiddleElementOfaStack {
    public static void deleteMid(Stack<Integer>s,int sizeOfStack){
        deleteMiddleUtil(s, sizeOfStack, 1);
        System.out.println(s);
    }
    public static void deleteMiddleUtil(Stack<Integer>stack,int size,int current){
        if (stack.isEmpty() || current == size / 2 + 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleUtil(stack, size, current + 1);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(40);
        s.add(50);
        deleteMid(s, s.size());
    }
}
