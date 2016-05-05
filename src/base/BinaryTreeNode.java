package base;

/**
 * Created by liuyang on 16/4/12.
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    public BinaryTreeNode parent;

    public BinaryTreeNode(int value){
        this(value,null,null);
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode){
        super();
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
