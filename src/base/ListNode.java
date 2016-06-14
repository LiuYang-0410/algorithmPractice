package base;

/**
 * Created by liuyang on 16/4/22.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
        this(value,null);
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public static ListNode generateList(int temp[]){
        ListNode fakeHead = new ListNode(1), curNode = fakeHead;
        for (int i : temp) {
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }
        return fakeHead.next;
    }

    public static ListNode generateList(String temp){
        ListNode fakeHead = new ListNode(1), curNode = fakeHead;
        String orig[] = temp.split(",");
        for (String i : orig) {
            curNode.next = new ListNode(Integer.valueOf(i));
            curNode = curNode.next;
        }
        return fakeHead.next;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printList(ListNode head){
        if (head == null){
            System.out.println("null");
            return;
        }
        System.out.print(head.val +" -> ");
        printList(head.next);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("val:").append(val).append("\tnext:");
        if (next != null)
            sb.append(next.val);
        else
            sb.append("null");
        return sb.toString();
    }
}
