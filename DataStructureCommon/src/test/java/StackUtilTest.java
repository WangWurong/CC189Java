import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class StackUtilTest {
    @Test
    public void testPrintStack() throws Exception {
        Stack<Integer> stack = StackUtil.initialStack(new Stack<>(), new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals("1 -> 2 -> 3 -> 4 -> 5\n", StackUtil.printStack(stack));
    }
}
