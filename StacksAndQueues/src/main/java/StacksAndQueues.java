import java.util.Stack;

public class StacksAndQueues {
    /**
     * Q3.5
     * pop the first one, if empty or smaller than peek, push
     * pop and push back
     * @return
     */
    public Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> res = new Stack<>();
        while (!input.isEmpty()) {
            int temp = input.pop();
            while (!res.isEmpty() && res.peek() < temp) {
                input.push(res.pop());
            }
            res.push(temp);
        }
        return res;
    }
}



