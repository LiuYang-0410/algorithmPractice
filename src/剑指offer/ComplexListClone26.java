package 剑指offer;

/**
 * Created by liuyang on 16/4/13.
 */
public class ComplexListClone26 {

    /**
     * 赋值复杂链表
     * @param head 原链表头
     * @return 新链表头
     */
    public ComplexListNode clone(ComplexListNode head){
        ComplexListNode curNode = head,newHead = new ComplexListNode(),curCloneNode = newHead;
        while (curNode != null){    //赋值节点,将其链在原节点之后
            ComplexListNode cloneNode = new ComplexListNode(curNode);
            curNode.next = cloneNode;
            curNode = cloneNode.next;
        }
        curNode = head;
        while (curNode != null){//设置克隆节点的sibling
            if (curNode.sibling != null)
                curNode.next.sibling = curNode.sibling.next;
            curNode = curNode.next.next;
        }
        curNode = head;
        while (curNode != null){
            //将克隆节点加到新链表
            curCloneNode.next = curNode.next;
            curCloneNode = curCloneNode.next;
            //将克隆节点从原链表中移除
            curNode.next = curCloneNode.next;
            curNode = curNode.next;
        }
        return newHead.next;
    }

    public void printComplexList(ComplexListNode head){
        ComplexListNode curNode = head;
        while (curNode != null){
            System.out.println(curNode);
            curNode = curNode.next;
        }
    }

    /**
     * 检测两个链表是否相同
     * @param listA 链表A
     * @param listB 链表B
     * @return 是否相同
     */
    public boolean isSameList(ComplexListNode listA, ComplexListNode listB){
        ComplexListNode nodeA = listA,nodeB = listB;
        while (nodeA != null){
            if (!nodeA.equals(nodeB))
                return false;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeB == null;
    }
    /**
     * 功能测试:普通链表
     */
    public void testNormalList(){
        System.out.println("*********普通链表*********");
        ComplexListNode nodeE = new ComplexListNode(5,null);
        ComplexListNode nodeD = new ComplexListNode(4,nodeE);
        ComplexListNode nodeC = new ComplexListNode(3,nodeD);
        ComplexListNode nodeB = new ComplexListNode(2,nodeC);
        ComplexListNode nodeA = new ComplexListNode(1,nodeB);
        nodeA.sibling = nodeC;
        nodeB.sibling = nodeE;
        nodeD.sibling = nodeB;
        System.out.println("原链表:");
        printComplexList(nodeA);
        ComplexListNode newList = clone(nodeA);
        System.out.println("赋值后的原链表:");
        printComplexList(nodeA);
        System.out.println("复制的链表:");
        printComplexList(newList);
        System.out.println("两链表是否相等:\t"+isSameList(nodeA,newList));
    }

    /**
     * 功能测试:sibling指向自身
     */
    public void testSelfSiblingList(){
        System.out.println("*********sibling指向自身的链表*********");
        ComplexListNode nodeE = new ComplexListNode(5,null);
        ComplexListNode nodeD = new ComplexListNode(4,nodeE);
        ComplexListNode nodeC = new ComplexListNode(3,nodeD);
        ComplexListNode nodeB = new ComplexListNode(2,nodeC);
        ComplexListNode nodeA = new ComplexListNode(1,nodeB);
        nodeA.sibling = nodeC;
        nodeB.sibling = nodeE;
        nodeD.sibling = nodeB;
        nodeC.sibling = nodeC;
        nodeE.sibling = nodeE;
        System.out.println("原链表:");
        printComplexList(nodeA);
        ComplexListNode newList = clone(nodeA);
        System.out.println("赋值后的原链表:");
        printComplexList(nodeA);
        System.out.println("复制的链表:");
        printComplexList(newList);
        System.out.println("两链表是否相等:\t"+isSameList(nodeA,newList));
    }

    /**
     * 功能测试:两个sibling形成环
     */
    public void testSiblingCycleList(){
        System.out.println("*********sibling形成环的链表*********");
        ComplexListNode nodeE = new ComplexListNode(5,null);
        ComplexListNode nodeD = new ComplexListNode(4,nodeE);
        ComplexListNode nodeC = new ComplexListNode(3,nodeD);
        ComplexListNode nodeB = new ComplexListNode(2,nodeC);
        ComplexListNode nodeA = new ComplexListNode(1,nodeB);
        nodeA.sibling = nodeC;
        nodeB.sibling = nodeE;
        nodeD.sibling = nodeB;
        nodeC.sibling = nodeE;
        nodeE.sibling = nodeC;
        System.out.println("原链表:");
        printComplexList(nodeA);
        ComplexListNode newList = clone(nodeA);
        System.out.println("赋值后的原链表:");
        printComplexList(nodeA);
        System.out.println("复制的链表:");
        printComplexList(newList);
        System.out.println("两链表是否相等:\t"+isSameList(nodeA,newList));
    }
    /**
     * 功能测试:单节点连标配
     */
    public void testSingleNodeList(){
        System.out.println("*********单节点链表*********");
        ComplexListNode nodeA = new ComplexListNode(1,null);
        nodeA.sibling = nodeA;
        System.out.println("原链表:");
        printComplexList(nodeA);
        ComplexListNode newList = clone(nodeA);
        System.out.println("赋值后的原链表:");
        printComplexList(nodeA);
        System.out.println("复制的链表:");
        printComplexList(newList);
        System.out.println("两链表是否相等:\t"+isSameList(nodeA,newList));
    }

    public static void main(String[] args) {
        ComplexListClone26 solution = new ComplexListClone26();
        solution.testNormalList();
        solution.testSelfSiblingList();
        solution.testSiblingCycleList();
        solution.testSingleNodeList();
    }

}

class ComplexListNode{
    int value;
    ComplexListNode next;
    ComplexListNode sibling;

    public ComplexListNode(){
        this(0,null,null);
    }

    public ComplexListNode(int value, ComplexListNode next){
        this(value,next,null);
    }

    public ComplexListNode(ComplexListNode node){
        this(node.value,node.next,node.sibling);
    }

    public ComplexListNode(int value, ComplexListNode next, ComplexListNode sibling){
        super();
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(value);
        sb.append(value);
        if (sibling != null)
            sb.append("\tsibling:\t").append(sibling.value);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        ComplexListNode node = (ComplexListNode)obj;
        if (this.value != node.value)
            return false;
        if (this.sibling == null && node.sibling != null
                || this.sibling != null && node.sibling == null)
            return false;
        if (this.sibling == null && node.sibling == null
                || this.sibling.value == node.sibling.value)
            return true;
        return false;
    }
}
