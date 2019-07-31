import javafx.util.Pair;

import java.util.Stack;

/**
 * Q3.2, use pair
 */
public class StackMin {
    Stack<Pair<Integer, Integer>> stack;

    public StackMin() {
        stack = new Stack<>();
    }

    public void push(int data) {
        if (stack.isEmpty()) {
            stack.push(new Pair<>(data, data));
        } else {
            Pair<Integer, Integer> top = stack.peek();
            stack.push(new Pair<>(data, Math.min(top.getValue(), data)));
        }
    }

    public int pop() {
        return stack.pop().getKey();
    }

    public int min() {
        return stack.peek().getValue();
    }

    public int peek() {
        return stack.peek().getKey();
    }
}
