import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class StacksAndQueuesTest {
    StacksAndQueues stacksAndQueues = new StacksAndQueues();

    @Test
    public void testSortStack() throws Exception {
        Stack<Integer> unsorted = StackUtil.initialStack(new Stack<>(), new int[]{1, 3, 5, 4, 2});
        Stack<Integer> sorted = stacksAndQueues.sortStack(unsorted);
        Assert.assertEquals("1 -> 2 -> 3 -> 4 -> 5\n", StackUtil.printStack(sorted));
    }
}
