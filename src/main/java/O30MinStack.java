import java.util.Stack;

public class O30MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public O30MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        int tmp = stack1.pop();
        if (stack2.peek() == tmp) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
