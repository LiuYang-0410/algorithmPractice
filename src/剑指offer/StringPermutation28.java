package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 16/4/13.
 */
public class StringPermutation28 {

    /**
     * 打印给定字符串的全排列结果
     * @param template 给定字符串
     */
    public void permutation(String template){
        if (template == null || template.length() <= 0)
            return;
        helper(template.toCharArray(),0);
        System.out.println();
    }

    private void helper(char templates[],int curIndex){
        if (curIndex == templates.length-1) //最后一位输出
            System.out.print(new String(templates)+"\t");
        for (int i = curIndex; i < templates.length; i++) {//当前位和后面的交换
            swap(templates,curIndex,i);
            helper(templates,curIndex+1);
            swap(templates,curIndex,i);
        }
    }

    private void swap(char ch[],int i,int j){
        if (i == j)
            return;
        char copyI = ch[i];
        ch[i] = ch[j];
        ch[j] = copyI;
    }

    /**
     * 打印给定字符序列的所有组合
     * @param template  给定字符序列
     */
    public void combination(String template){
        if (template == null || template.length() <= 0)
            return;
        for (int i = 0; i < template.length(); i++)
            combinationHelper(template.toCharArray(),i);
        System.out.println();
    }

    private void combinationHelper(char templates[],int count){
        for (int windowI = 0; windowI < templates.length - count; windowI++) {
            printWindow(templates,windowI,windowI+count);
            for (int i = windowI+1; i <= windowI+count; i++)
                for (int j = windowI+count+1; j < templates.length; j++) {
                    swap(templates,i,j);
                    printWindow(templates,windowI,windowI+count);
                    swap(templates,i,j);
                }
        }
    }

    /**
     * 打印字符数组中一个窗口的大小
     * @param ch    字符数组
     * @param windowBegin   窗口开始索引(包含)
     * @param windowEnd 窗口开始索引(包含)
     */
    private void printWindow(char ch[],int windowBegin,int windowEnd){
        for (int i = windowBegin; i <= windowEnd; i++)
            System.out.print(ch[i]);
        System.out.print("\t");
    }

    /**
     * 打印给定字符序列的所有组合
     * @param template  给定字符序列
     */
    public void combination2(String template){//递归
        if (template == null || template.length() <= 0)
            return;
        for (int i = 0; i < template.length(); i++){
            List<String> res = combinationHelper2(template.toCharArray(),0,i);
            for (String  s: res)
                System.out.print(s+"\t");
        }
        System.out.println();
    }

    private List<String> combinationHelper2(char templates[], int beginIndex, int count){//递归
        List<String> resultList = new ArrayList<>();
        if (beginIndex >= templates.length - count)
            return resultList;
        //包含首字符
        if (count == 0) //当前就剩最后一个字符
            resultList.add(String.valueOf(templates[beginIndex]));
        else {//还有多个字符
            List<String> containList = combinationHelper2(templates,beginIndex+1,count-1);
            if (!containList.isEmpty()){
                for (String str : containList)
                    resultList.add(templates[beginIndex]+str);
            }
        }
        //不包含首字符
        List<String> notContainList = combinationHelper2(templates,beginIndex+1,count);
        if (!notContainList.isEmpty())
            resultList.addAll(notContainList);
        return resultList;
    }

    public static void main(String[] args) {
        StringPermutation28 solution = new StringPermutation28();
        System.out.println("***********a的全排列***********");
        solution.permutation("a");
        System.out.println("***********abcd的全排列***********");
        solution.permutation("abcd");
        System.out.println("***********a的全组合***********");
        solution.combination("a");
        System.out.println("***********abcd的全组合***********");
        solution.combination("abcd");
        System.out.println("***********a的全组合***********");
        solution.combination2("a");
        System.out.println("***********abcd的全组合***********");
        solution.combination2("abcd");
    }

}
