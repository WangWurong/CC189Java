import org.omg.CORBA.INTERNAL;

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

    /**
     * Q2.5
     * @param list1
     * @param list2
     * @return
     */
    public SinglyLinkedList sumLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList res = new SinglyLinkedList();
        IntNode cur1 = list1.head;
        IntNode cur2 = list2.head;
        IntNode cur3 = new IntNode(0);
        res.head = cur3;
        int carrier = 0;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carrier;
            int num = sum % 10;
            carrier = sum / 10;
            cur3.next = new IntNode(num);
            cur3 = cur3.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        cur1 = cur1 != null ? cur1 : cur2;
        while (cur1 != null) {
            int sum = cur1.val + carrier;
            int num = sum % 10;
            carrier = sum / 10;
            cur3.next = new IntNode(num);
            cur3 = cur3.next;
            cur1 = cur1.next;
        }

        if (carrier != 0) {
            cur3.next = new IntNode(carrier);
        }
        res.head = res.head.next;
        return res;
    }

    /**
     * Q2.6
     * just reverse and compare
     * @param list
     * @return
     */
    public boolean palindrome(SinglyLinkedList list) {
        SinglyLinkedList reverse = SinglyLinkedList.reverseAndClone(list);
        return SinglyLinkedList.compareList(list, reverse);
    }

    /**
     * Q2.7
     * if two list have the same length, they will meet at the intersection at the same time and the meet point
     * is the intersection
     * while if they are not the same length, we can make them to be the same by add the unequal part together
     * that is to say
     * when cur1 finished, point it to the list2.head, until they meet, the meet point is the intersection
     * @param list1
     * @param list2
     * @return
     */
    public IntNode intersection(SinglyLinkedList list1, SinglyLinkedList list2) {
        IntNode cur1 = list1.head;
        IntNode cur2 = list2.head;
        while (cur1 != null || cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            } else {
                if (cur1 == null) {
                    cur1 = list2.head;
                } else if (cur2 == null) {
                    cur2 = list1.head;
                }
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    /**
     * Q2.8
     * faster and slow pointer, if has loop, the faster and slower will meet
     * if there is no loop, faster will reach the null
     * if there is loop, the start to the collision point will be same as
     * the head to the collision point
     * @param list
     * @return
     */
    public IntNode loopDetection(SinglyLinkedList list) {
        IntNode slow = list.head;
        IntNode fast = list.head;
        while (fast != null && fast.next != null) {
            if (fast != list.head && fast == slow) {
                // find the collision point
                slow = list.head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
}
