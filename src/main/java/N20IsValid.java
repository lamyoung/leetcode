import java.util.Stack;

public class N20IsValid {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || !pair(stack.peek(), s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean pair(char a, char b) {
        if (a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']') {
            return true;
        }
        return false;
    }
}
