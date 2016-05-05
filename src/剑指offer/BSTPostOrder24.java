package 剑指offer;

/**
 * Created by liuyang on 16/4/12.
 */
public class BSTPostOrder24 {

    /**
     * 判断输入是否为某二叉搜索树的后序遍历序列
     * @param num   后序遍历
     * @return 是否有对应的BST
     */
    public boolean isPostOrderofBST(int num[]){
        if (num == null || num.length <= 0)
            return false;
        return helper(num,0,num.length-1);
    }

    private boolean helper(int num[],int beginIndex,int endIndex){
        if (beginIndex >= endIndex)
            return true;
        int i = 0;
        while (num[i++] < num[endIndex]);
        int split = --i;
        while (num[i++] > num[endIndex]);
        if (i <= endIndex)
            return false;
        return helper(num,beginIndex,split-1) && helper(num,split,endIndex-1);
    }

    public static void main(String[] args) {
        BSTPostOrder24 solution = new BSTPostOrder24();
        {
            System.out.println("*********完全二叉树*********");
            int num[] = {5,7,6,9,11,10,8};
            System.out.println(solution.isPostOrderofBST(num));
        }
        {
            System.out.println("*********只包含左子树的二叉树*********");
            int num[] = {1,2,3,4,5};
            System.out.println(solution.isPostOrderofBST(num));
        }
        {
            System.out.println("*********只有一个节点的二叉树*********");
            int num[] = {5};
            System.out.println(solution.isPostOrderofBST(num));
        }
        {
            System.out.println("*********无对应二叉树*********");
            int num[] = {7,4,6,5};
            System.out.println(solution.isPostOrderofBST(num));
        }
    }

}
