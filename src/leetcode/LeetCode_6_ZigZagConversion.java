package leetcode;

/**
 * Created by liuyang on 16/5/13.
 */
public class LeetCode_6_ZigZagConversion {  //https://leetcode.com/discuss/94364/java-solution-easy-and-clear-interesting-approach
    /**
     * 锯齿状打印输入
     * @param s 输入字符串
     * @param numRows   总行数
     * @return  锯齿状结果
     */
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
        String re="";
        for(int i=0;i<sb.length;i++){
            re+=sb[i];
        }
        return re.toString();
    }

    public String convert2(String s, int n) {   //16ms
        if (n == 1)
            return s;
        int maxGroupCount = 2*n-2;
        int cols = (int)Math.ceil(1.0*s.length()/maxGroupCount)*2;
        char res[][] = new char[n][cols];
        for (int curRow = 0; curRow < n; curRow++)
            for (int curCol = 0,index = curRow; index < s.length(); curCol+=2,index += maxGroupCount)
                res[curRow][curCol] = s.charAt(index);
        for (int curRow = n-2, beginIndex = n; curRow > 0; curRow--,beginIndex++)
            for (int curCol = 1,index = beginIndex; index < s.length(); curCol+=2,index += maxGroupCount)
                res[curRow][curCol] = s.charAt(index);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[i].length; j++)
                if (res[i][j] != 0x00)
                    sb.append(res[i][j]);
        return sb.toString();
    }

    public String convert3(String s, int n) {   //7ms
        if (n == 1)
            return s;
        char res[] = new char[s.length()];
        for (int row = 0,i=0,groupCount = 2*n-2; row < n; row++)
            for (int index = row,secIndex = groupCount-row; index < s.length();index += groupCount,secIndex += groupCount){
                res[i++] = s.charAt(index);
                if (row >0 && row < n-1 && secIndex < s.length())
                    res[i++] = s.charAt(secIndex);
            }
        return new String(res);
    }

    public static void main(String[] args) {
        LeetCode_6_ZigZagConversion tool = new LeetCode_6_ZigZagConversion();
        System.out.println(tool.convert("PAYPALISHIRING",3));
        System.out.println(tool.convert2("PAYPALISHIRING",3));
        System.out.println(tool.convert3("PAYPALISHIRING",3));
    }
}
