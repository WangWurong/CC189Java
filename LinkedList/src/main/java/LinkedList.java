import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    /**
     * Q2.1 remove duplicates in unsorted linked list
     * @param input
     * @return
     */
    public SinglyLinkedList removeDup(SinglyLinkedList input) {
        // method1: use hashset to store the points
//        Set<Integer> set = new HashSet<>();
//        IntNode cur  = input.head;
//        if (cur != null) {
//            set.add(cur.val);
//        }
//        while (cur != null && cur.next != null) {
//            if (!set.add(cur.next.val)) {
//                // the val appeared before, remove
//                cur.next = cur.next.next;
//            }
//            cur = cur.next;
//        }

        // method2: not allow to use temperate space, then we need to use time
        // loop twice
        IntNode i  = input.head;
        while (i != null) {
            IntNode j  = i;
            while (j != null && j.next != null) {
                if (j.next.val == i.val) {
                    j.next = j.next.next;
                }
                j = j.next;
            }
            i = i.next;
        }

        return input;
    }

    /**
     * Q2.2: k start from 0 - n-1
     * fast and slow pointers
     * @param input
     * @param k
     * @return
     */
    public int returnKthToLast(SinglyLinkedList input, int k) {
        IntNode fast = input.head;
        IntNode slow = input.head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!= null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * Q2.3
     * slow and fast, fast run two step and slow run one step
     * @param input
     */
    public void removeMiddle(SinglyLinkedList input) {
        IntNode dummy = new IntNode(0);
        dummy.next = input.head;
        IntNode slow = dummy;
        IntNode fast = input.head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }

    /**
     * Q2.4 two dummy nodes
     * smaller than x, insert after dummy. and add an end pointer
     * larger than x, insert after end pointer
     * @param input
     * @param x
     */
    public void partition(SinglyLinkedList input, int x) {
        IntNode dummy = new IntNode(0);
        dummy.next = input.head;
        IntNode cur = input.head;
        while(cur.next != null) {
            if (cur.next.val < x) {
                // insert after dummy
                IntNode newNode = cur.next;
                cur.next = cur.next.next;
                newNode.next = dummy.next;
                dummy.next = newNode;
            } else {
                // keep this node after end
                cur = cur.next;
            }
        }
        input.head = dummy.next;
    }
}
