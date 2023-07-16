//GFG: https://practice.geeksforgeeks.org/problems/queue-reversal/1

import java.util.*;
public class QueueReversal {
    public static Queue<Integer> rev(Queue<Integer> q){
        Stack<Integer> stack = new Stack<Integer>();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        queue.add(3);
        queue.add(1);
        queue.add(10);
        queue.add(2);
        queue.add(6);
        System.out.println(rev(queue));
    }
}
