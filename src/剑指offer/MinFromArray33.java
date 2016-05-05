package 剑指offer;

/**
 * Created by liuyang on 16/4/15.
 */
public class MinFromArray33 {

    /**
     * 把数组排成最小数
     * @param num   输入数组
     * @return  最小的书,可能超过int的表示范围,用String表示
     */
    public String findMinNumber(int num[]){
        String temp[] = new String[num.length];
        for (int i = 0; i < temp.length; i++)
            temp[i] = String.valueOf(num[i]);
        quickSort(temp,0,temp.length-1);
        StringBuffer result = new StringBuffer();
        for (String str : temp)
            result.append(str);
        if (result.charAt(0) == '0'){
            int noZeroIndex = 0;
            while (noZeroIndex < result.length() && result.charAt(noZeroIndex) == '0')
                noZeroIndex++;
            result.setCharAt(0,result.charAt(noZeroIndex));
            result.setCharAt(noZeroIndex,'0');
        }
        return result.toString();
    }

    private void quickSort(String str[],int beginIndex,int endIndex){
        if (beginIndex >= endIndex)
            return;
        int pivotIndex = beginIndex;
        for (int i = beginIndex+1;i <= endIndex;i++)
            if (compare(str[i],str[beginIndex])){
                String copy = str[i];
                str[i] = str[pivotIndex+1];
                str[pivotIndex+1] = str[pivotIndex];
                str[pivotIndex++] = copy;
            }
        quickSort(str,beginIndex,pivotIndex-1);
        quickSort(str,pivotIndex+1,endIndex);
    }


    /**
     * 若str1str2表示的数字<=str2str1,str1小于str2
     * @param str1  第一个字符串表示数字
     * @param str2  第二个字符串表示数字
     * @return  true:str1小于等于str2,false:str2小于str1
     */
    private boolean compare(String str1,String str2){
        String temp1 = str1.concat(str2);
        String temp2 = str2.concat(str1);
        if (temp1.compareTo(temp2) <= 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        MinFromArray33 tool = new MinFromArray33();
        {
            int num[] = {3,32,321};
            System.out.println("形成的最小数:\t"+tool.findMinNumber(num));
        }
        {
            int num[] = {3,32,327};
            System.out.println("形成的最小数:\t"+tool.findMinNumber(num));
        }
        {
            int num[] = {7,5,3,0,1,6,4,2};
            System.out.println("形成的最小数:\t"+tool.findMinNumber(num));
        }
    }

}

class A {
//    static  int top = 10;

    int aha;
    public void lala(){
//        int top = 5;
        System.out.println(this.aha);
    }


}
