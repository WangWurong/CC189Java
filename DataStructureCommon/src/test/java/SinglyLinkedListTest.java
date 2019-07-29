import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {
    @Test
    public void testInitialize() throws Exception {
        int[] stdList1 = new int[]{1, 2, 3, 4, 5};
        SinglyLinkedList list = new SinglyLinkedList(stdList1);
        Assert.assertEquals("1 -> 2 -> 3 -> 4 -> 5\n", list.printout());

        int[] stdList2 = new int[]{1};
        list = new SinglyLinkedList(stdList2);
        Assert.assertEquals("1\n", list.printout());
    }
}
