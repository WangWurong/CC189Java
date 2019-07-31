import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    LinkedList linkedList = new LinkedList();

    @Test
    public void testRemoveDup() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{3, 2, 1, 4, 4, 0});
        Assert.assertEquals("3 -> 2 -> 1 -> 4 -> 0\n", linkedList.removeDup(test1).printout());
    }

    @Test
    public void testReturnKthToLast() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{3, 2, 1, 4, 4, 0});
        Assert.assertEquals(1, linkedList.returnKthToLast(test1, 3));
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        linkedList.removeMiddle(test1);
        Assert.assertEquals("1 -> 2 -> 4 -> 5 -> 6\n", test1.printout());
    }

    @Test
    public void testPartition() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{3, 5, 8, 5, 10, 2, 1});
        linkedList.partition(test1, 5);
        Assert.assertEquals("1 -> 2 -> 3 -> 5 -> 8 -> 5 -> 10\n", test1.printout());
    }

    @Test
    public void testSumLists() throws Exception {
        SinglyLinkedList test1list1 = new SinglyLinkedList(new int[]{7, 1, 6});
        SinglyLinkedList test1list2 = new SinglyLinkedList(new int[]{5, 9, 2});
        Assert.assertEquals("2 -> 1 -> 9\n", linkedList.sumLists(test1list1, test1list2).printout());

        SinglyLinkedList test2list1 = new SinglyLinkedList(new int[]{7, 1, 9});
        SinglyLinkedList test2list2 = new SinglyLinkedList(new int[]{9, 6});
        Assert.assertEquals("6 -> 8 -> 9\n", linkedList.sumLists(test2list1, test2list2).printout());
    }

    @Test
    public void testPalindrome() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{1, 2, 3, 3, 1});
        SinglyLinkedList test2 = new SinglyLinkedList(new int[]{1, 2, 3, 2, 1});
        SinglyLinkedList test3 = new SinglyLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        Assert.assertFalse(linkedList.palindrome(test1));
        Assert.assertTrue(linkedList.palindrome(test2));
        Assert.assertTrue(linkedList.palindrome(test3));
    }

    @Test
    public void testIntersection() throws Exception {
        SinglyLinkedList test1list1 = new SinglyLinkedList(new int[]{1, 2, 3, 3, 1});
        SinglyLinkedList test1list2 = new SinglyLinkedList(new int[]{7, 8, 3, 3, 1});
        IntNode test1Intersection = linkedList.intersection(test1list1, test1list2);
        Assert.assertNull(test1Intersection);

        SinglyLinkedList test2list1 = new SinglyLinkedList(new int[]{1, 2, 3, 3, 1});
        SinglyLinkedList test2list2 = new SinglyLinkedList(new int[]{7, 8});
        IntNode cur1 = test2list1.head;
        IntNode cur2 = test2list2.head;
        while (cur2.val != 8) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        IntNode test2Intersection = cur1.next;
        cur2.next = cur1.next;
        Assert.assertEquals(test2Intersection, linkedList.intersection(test2list1, test2list2));

        SinglyLinkedList test3list1 = new SinglyLinkedList(new int[]{1, 2, 5, 4, 3, 3, 1});
        SinglyLinkedList test3list2 = new SinglyLinkedList(new int[]{7, 8});
        cur1 = test3list1.head;
        cur2 = test3list2.head;
        while (cur2.val != 8) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1.val != 3) {
            cur1 = cur1.next;
        }
        IntNode test3Intersection = cur1;
        cur2.next = cur1;
        Assert.assertEquals(test3Intersection, linkedList.intersection(test3list1, test3list2));
    }

    @Test
    public void testLoopDetection() throws Exception {
        SinglyLinkedList test1 = new SinglyLinkedList(new int[]{1, 2, 3, 3, 1});
        IntNode test1Node = linkedList.loopDetection(test1);
        Assert.assertNull(test1Node);

        SinglyLinkedList test2 = new SinglyLinkedList(new int[]{1, 2, 3, 3, 1});
        IntNode cur = test2.head;
        while (cur.val != 3) {
            cur = cur.next;
        }
        IntNode test2Expect = cur;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        cur.next = test2Expect;
        Assert.assertEquals(test2Expect, linkedList.loopDetection(test2));
    }
}
