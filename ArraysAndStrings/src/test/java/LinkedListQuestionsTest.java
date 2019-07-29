import org.junit.Assert;
import org.junit.Test;

public class LinkedListQuestionsTest {
    LinkedListQuestions linkedListQuestions = new LinkedListQuestions();

    @Test
    public void testRemoveDup() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{3, 2, 1, 4, 4, 0});
        Assert.assertEquals("3 -> 2 -> 1 -> 4 -> 0\n", linkedListQuestions.removeDup(test1).printout());
    }

    @Test
    public void testReturnKthToLast() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{3, 2, 1, 4, 4, 0});
        Assert.assertEquals(1, linkedListQuestions.returnKthToLast(test1, 3));
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        linkedListQuestions.removeMiddle(test1);
        Assert.assertEquals("1 -> 2 -> 4 -> 5 -> 6\n", test1.printout());
    }

    @Test
    public void testPartition() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{3, 5, 8, 5, 10, 2, 1});
        linkedListQuestions.partition(test1, 5);
//        Assert.assertEquals("3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10\n", test1.printout());
    }
}
