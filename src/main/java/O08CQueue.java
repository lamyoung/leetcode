import java.util.Stack;

class O08CQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public O08CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if(out.isEmpty()) {
            if(in.isEmpty()) {
                return -1;
            } else {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.pop();
            }
        } else {
            return out.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
