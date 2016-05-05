package base;

/**
 * Created by liuyang on 16/4/22.
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this(value,null);
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public static void printList(ListNode head){
        if (head == null){
            System.out.println("null");
            return;
        }
        System.out.print(head.value+" -> ");
        printList(head.next);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("value:").append(value).append("\tnext:");
        if (next != null)
            sb.append(next.value);
        else
            sb.append("null");
        return sb.toString();
    }
}
