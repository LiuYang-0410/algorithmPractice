package 剑指offer;

/**
 * Created by liuyang on 16/4/25.
 */
public class MockAddOP47 {

    /**
     * 不使用四则运算符实现加法运算
     * @param num1  数1
     * @param num2  数2
     * @return  相加的和
     */
    public int addTwoNumbers(int num1,int num2){
        int sum = 0, carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);
        return num1;
    }

    /**
     * 测试加法运算
     */
    public void testADDOperation(){
        System.out.println("*************测试加法运算*************");
        System.out.println("5 + 7 = "+addTwoNumbers(5,7));
        System.out.println("0 + 3 = "+addTwoNumbers(0,3));
        System.out.println("-11 + -90 = "+addTwoNumbers(-11,-90));
    }

    public static void main(String[] args) {
        MockAddOP47 tool = new MockAddOP47();
        tool.testADDOperation();
    }
}
