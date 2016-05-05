package 剑指offer;

/**
 * Created by liuyang on 16/4/15.
 */
public class CountOneInN32 {

    /**
     * 计算从1到N整数中1出现的次数
     * @param N N
     * @return  1出现的次数
     */
    public int numberOf1InN(int N){
        int count = 0;
        String nStr = String.valueOf(N);
        String lessNStr = nStr.substring(1);    //去掉最高位
        if (nStr.startsWith("1"))   //出现在最高位的1的个数
            count += Integer.parseInt(lessNStr)+1;
        else
            count += Math.pow(10,lessNStr.length());
        count += (N/Math.pow(10,lessNStr.length())) * Math.pow(10,lessNStr.length()-1);  //出现在后四位的1的个数
        if (lessNStr.length() > 0)
            count += numberOf1InN(Integer.parseInt(lessNStr));
        return count;
    }

    public static void main(String[] args) {
        CountOneInN32 tool = new CountOneInN32();
        System.out.println(tool.numberOf1InN(12));
    }

}
