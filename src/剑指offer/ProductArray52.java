package 剑指offer;

/**
 * Created by liuyang on 16/4/25.
 */
public class ProductArray52 {

    /**
     * 乘积数组 Bi = A1*A2...*Ai-1*Ai+1*...An-1
     * @param A 输入数组
     * @return  返回乘积数组B
     */
    public int [] createProductArray(int A[]){
        if (A == null || A.length <= 0)
            return null;
        int B[] = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < B.length; i++)   // Bi = A1*A2...*Ai-1
            B[i] = B[i-1] * A[i-1];
        int temp[] = new int[B.length];
        temp[temp.length-1] = 1;
        for (int i = temp.length-2; i >= 0 ; i--){// Bi = Ai+1*...An-1
            temp[i] = temp[i+1] * A[i+1];
            B[i] *= temp[i];
        }
        return B;
    }

    public int [] test(int A[]){
        if (A == null || A.length <= 0)
            return null;
        int total = 1;
        for (int i : A)
            total *= i;
        int B[] = new int[A.length];
        for (int i = 0; i < B.length; i++)
            B[i] = total/A[i];
        return B;
    }

    public static void main(String[] args) {
        ProductArray52 tool = new ProductArray52();
        int A[] = {1,2,6,3,7,6,3,7,9};
        int res[] = tool.createProductArray(A);
        int rig[] = tool.test(A);
        System.out.print("solution1:\t");
        for (int right : rig)
            System.out.print(right+"\t");
        System.out.print("\nsolution2:\t");
        for (int result : res)
            System.out.print(result+"\t");
    }

}
