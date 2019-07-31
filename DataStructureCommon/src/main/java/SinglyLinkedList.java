/**
 * This is a self implemented singly linked list
 * allow int because generic type doesn't allow primitive type
 */
public class SinglyLinkedList {
    IntNode head;

    public SinglyLinkedList() { }

    /**
     * Initial with an array
     * @param list
     */
    public SinglyLinkedList(int[] list) {
        head = null;
        for (int item : list) {
            this.insert(item);
        }
    }

    public void insert(int data) {
        IntNode newNode = new IntNode(data);
        if (head == null) {
            head = newNode;
        } else {
            IntNode cur = head;
            // find the last
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public String printout() {
        IntNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur.next != null) {
            sb.append(cur.val + " -> ");
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        sb.append(cur.val + "\n");
        System.out.print(cur.val + "\n");
        return sb.toString();
    }

    public static SinglyLinkedList reverseAndClone(SinglyLinkedList list) {
        SinglyLinkedList res = new SinglyLinkedList();
        res.head = new IntNode(0);
        IntNode cur1 = res.head; // cur of new list
        IntNode cur2 = list.head; // cur of original list
        while (cur2 != null) {
            IntNode newNode = new IntNode(cur2.val);
            newNode.next = cur1.next;
            cur1.next = newNode;
            cur2 = cur2.next;
        }
        res.head = res.head.next;
        return res;
    }

    public static boolean compareList(SinglyLinkedList list1, SinglyLinkedList list2) {
        IntNode cur1 = list1.head;
        IntNode cur2 = list2.head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1 == null && cur2 == null;
    }
}
