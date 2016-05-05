package 剑指offer;

import base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 16/4/12.
 */
public class BTFindPath25 {

    List<Integer> paths;

    public BTFindPath25(){
        paths = new ArrayList<>();
    }

    /**
     * 打印出二叉树中节点值和为输入整数的所有路径
     * @param root  二叉树的根
     * @param sum   节点和
     */
    public void findPath(BinaryTreeNode root, int sum){
        if (root == null || sum < root.value)
            return;
        paths.add(root.value);
        sum -= root.value;
        if (root.leftNode == null && root.rightNode == null && sum == 0){//到叶子节点
            printPath();
            return;
        }
        if (root.leftNode != null){    //左孩子不为空
            findPath(root.leftNode,sum);
            paths.remove(paths.size()-1);
        }
        if (root.rightNode != null){  //右孩子不为空
            findPath(root.rightNode,sum);
            paths.remove(paths.size()-1);
        }
    }

    private void printPath(){
        for (int i : paths)
            System.out.print(i+"\t");
        System.out.println();
    }

    public static void main(String[] args) {
        BTFindPath25 solution = new BTFindPath25();
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5,node4,node7);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode root = new BinaryTreeNode(10,node5,node12);
        solution.findPath(root,22);
    }

}
