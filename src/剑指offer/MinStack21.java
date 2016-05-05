package 剑指offer;

import java.util.Stack;

/**
 * Created by liuyang on 16/4/11.
 * 包含min函数的栈,要求min,push,pop的时间复杂度都是O(1)
 */
public class MinStack21 {

    Stack<Integer> stack;
    Stack<Integer> helpStack;

    public MinStack21(){
        super();
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if (helpStack.isEmpty())
            helpStack.push(val);
        else if (val <= helpStack.peek())
            helpStack.push(val);
    }

    public Integer pop(){
        if (stack.isEmpty())
            return null;
        Integer peakVal = stack.pop();
        Integer curMin = helpStack.peek();
        if (peakVal == curMin)
            helpStack.pop();
        return peakVal;
    }

    public Integer min(){
        if (helpStack.isEmpty())
            return null;
        return helpStack.peek();
    }

    public static void main(String[] args) {
        MinStack21 minStack = new MinStack21();
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(0);
        System.out.println(minStack.min());
    }

}
