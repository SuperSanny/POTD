//LeetCode: https://leetcode.com/problems/implement-stack-using-queues/description/
import java.util.*;
class MyStack{
    Queue<Integer> queue;
    int top;
    public MyStack() {
        queue = new LinkedList<>();
        top = -1;
    }
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }
    public int pop() {
        return queue.remove();
    }
    public int top() {
        return queue.peek();
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
public class ImplementStackusingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int para1 = myStack.top();
        int para2 = myStack.pop();
        boolean para3 = myStack.empty();
        System.out.println(para1+" "+ para2+" "+ para3);
    }
}
