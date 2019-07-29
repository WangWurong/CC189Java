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
}
