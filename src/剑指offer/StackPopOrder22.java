package 剑指offer;

import java.util.Stack;

/**
 * Created by liuyang on 16/4/12.
 */
public class StackPopOrder22 {

    /**
     * 判断一个序列是否是该栈的出栈顺序
     * @param pushOrder 入站顺序
     * @param popOrder  出栈顺序
     * @return 是出栈顺序为YES,反之为NO
     */
    public boolean isPopOrder(int pushOrder[],int popOrder[]){
        if (pushOrder == null || popOrder == null || popOrder.length != pushOrder.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int pushNumber : pushOrder) {
            stack.push(pushNumber);
            while (popIndex < popOrder.length && popOrder[popIndex] == stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        return popIndex == popOrder.length;
    }

    public static void main(String[] args) {
        StackPopOrder22 solution = new StackPopOrder22();
        int pushOrder[] = {1,2,3,4,5};
        int popOrder[] = {4,5,3,2,1};
        System.out.println(solution.isPopOrder(pushOrder,popOrder));
        int popOrder1[] = {4,3,5,1,2};
        System.out.println(solution.isPopOrder(pushOrder,popOrder1));
    }

}
