import java.util.Stack;

public final class StackUtil {
    /**
     * print put the stack from top to bottom
     * @return
     */
    public static String printStack(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 1) {
            int cur = stack.pop();
            System.out.print(cur + " -> ");
            sb.append(cur + " -> ");
        }
        int last = stack.pop();
        System.out.print(last + "\n");
        sb.append(last + "\n");
        return sb.toString();
    }

    public static Stack<Integer> initialStack(Stack<Integer> stack, int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            stack.push(values[i]);
        }
        return stack;
    }
}
