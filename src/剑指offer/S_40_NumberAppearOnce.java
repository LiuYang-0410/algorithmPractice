package 剑指offer;

public class S_40_NumberAppearOnce {

	public void find(int num[]) {
		int xor = 0, base = 1, left = 0, right = 0;
		for (int i : num) 
			xor ^= i;
		while ((xor & base) == 0) 
			base <<= 1;
		for (int i : num) 
			if ((i & base) == 1) 
				left ^= i;
			else 
				right ^= i;
		System.out.println(left + "\t" + right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 测试用例：
		 * 1. 只有两个不同的数
		 * 2. 只有一对出现两次
		 * 3. 多对出现两次  
		 */
		S_40_NumberAppearOnce numberAppearOnce = new S_40_NumberAppearOnce();
		int num[] = {2,4,3,6,3,2,5,5};
		numberAppearOnce.find(num);
	}

}
