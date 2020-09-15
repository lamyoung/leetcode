import java.util.Stack;

public class N155MinStack {

    Stack<Integer> stack;
    Stack<Integer> alias;

    public N155MinStack() {
        stack = new Stack<>();
        alias = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x < alias.peek()) {
            alias.push(x);
        } else {
            alias.push(alias.peek());
        }
        stack.push(x);
    }

    public void pop() {
        alias.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return alias.peek();
    }
}
