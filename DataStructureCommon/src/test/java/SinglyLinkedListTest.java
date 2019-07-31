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

    @Test
    public void testReverseAndClone() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList(new int[]{1, 2, 3});
        SinglyLinkedList res = SinglyLinkedList.reverseAndClone(list);
        Assert.assertEquals("3 -> 2 -> 1\n", res.printout());
    }

    @Test
    public void testCompareList() throws Exception {
        SinglyLinkedList list1 = new SinglyLinkedList(new int[]{1, 2, 3});
        SinglyLinkedList list2 = new SinglyLinkedList(new int[]{1, 2, 3});
        Assert.assertTrue(SinglyLinkedList.compareList(list1, list2));

        SinglyLinkedList list3 = new SinglyLinkedList(new int[]{1, 2, 3});
        SinglyLinkedList list4 = new SinglyLinkedList(new int[]{1, 3, 3});
        Assert.assertFalse(SinglyLinkedList.compareList(list3, list4));
    }
}
