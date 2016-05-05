package 剑指offer;

/**
 * Created by liuyang on 16/4/23.
 */
public class ReverseString42 {

    /**
     * 反转句子中单词的顺序,但单词内字符的顺序不变
     * @param str   给定句子
     */
    public void reverseString(StringBuffer str){
        if (str == null || str.length() <= 1)
            return;
        reverse(str,0,str.length()-1);  //整体翻转
        int begin = 0;
        while (begin < str.length()){
            int end = str.indexOf(" ",begin);
            if (end == -1)
                end = str.length();
            reverse(str,begin,end-1);
            begin = end+1;
        }
    }

    private void reverse(StringBuffer sb,int begin,int end){
        while (begin < end){    //整体翻转
            char ch = sb.charAt(end);
            sb.setCharAt(end--,sb.charAt(begin));
            sb.setCharAt(begin++,ch);
        }
    }

    /**
     * 将字符串前面的若干个字符转到字符的尾部
     * @param str   给定字符串
     * @param k 旋转前面k的字符
     */
    public void leftRotate(StringBuffer str, int k){
        if (str == null || str.length() <= 1 || k <= 0)
            return;
        k = k > str.length() ? str.length() : k;
        reverse(str,0,k-1); //旋转前半部分
        reverse(str,k,str.length()-1);  //旋转后半部分
        reverse(str,0,str.length()-1);  //整体旋转
    }

    public static void main(String[] args) {
        ReverseString42 tool = new ReverseString42();
        {
            System.out.println("*********翻转字符串*********");
            StringBuffer sb = new StringBuffer("I am a student.");
            System.out.println("原字符串:\t"+sb.toString());
            tool.reverseString(sb);
            System.out.println("翻转后:\t"+sb.toString());
        }
        {
            System.out.println("*********左旋字符串*********");
            System.out.println("原字符串:\tabcdefg");
            for (int i = 0; i < 10; i++) {
                StringBuffer sb = new StringBuffer("abcdefg");
                tool.leftRotate(sb,i);
                System.out.println("翻转"+i+"位:\t"+sb.toString());
            }

        }
    }
}
