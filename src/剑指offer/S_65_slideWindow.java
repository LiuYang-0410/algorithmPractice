package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ly_anna on 2016/9/12.
 */
public class S_65_slideWindow {

    public static List<Integer> maxValue(int num[], int k){
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.getLast()] <= num[i]){
                queue.removeLast();
            }
            queue.add(i);
            if (i - queue.getFirst() == k)
                queue.removeFirst();
            if (i >= k-1)
                ans.add(num[queue.getFirst()]);
        }
        return ans;
    }

    public static void main(String[] args) {
        S_65_slideWindow slideWindow = new S_65_slideWindow();
        int num[] = {2,3,4,2,6,2,5,1};
        List<Integer> ans = S_65_slideWindow.maxValue(num,3);
        for (int i : ans) {
            System.out.println(i+"\t");
        }
    }
}
