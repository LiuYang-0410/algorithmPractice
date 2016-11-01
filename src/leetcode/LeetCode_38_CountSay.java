package leetcode;

/**
 * Created by ly_anna on 2016/10/28.
 */
public class LeetCode_38_CountSay {
    public static String countAndSay(int n) {//6ms
        String ans = "1";
        while (--n > 0){
            StringBuffer temp = new StringBuffer();
            int count = 1;
            for (int i = 1,size = ans.length(); i < size; i++) {
                if (ans.charAt(i) == ans.charAt(i-1)){
                    count++;
                }else {
                    temp.append(count).append(ans.charAt(i-1));
                    count = 1;
                }
            }
            temp.append(count).append(ans.charAt(ans.length()-1));
            ans = temp.toString();
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i+" : " + countAndSay(i));
        }
    }
}
