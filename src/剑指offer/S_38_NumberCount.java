package 剑指offer;

public class S_38_NumberCount {

	public int get(int num[], int k) {
		int first = getFirst(num, k, 0, num.length-1);
		int last = getLast(num, k, 0, num.length-1);
		if (first == -1 || last == num.length) {
			return 0;
		}
		return last - first + 1;
	}
	
	private int getFirst(int num[],int k, int begin, int end) {
		if (end < begin || begin < 0 || end == num.length) {
			return -1;
		}
		int mid = (begin+end)/2;
		if (num[mid] < k) {
			return getFirst(num, k, mid+1, end);
		}else{
			if (num[mid] == k && (mid == 0 || num[mid-1] != k) ) {
				return mid;
			}
			return getFirst(num, k, begin, mid-1);
		}
	}
	
	private int getLast(int num[],int k, int begin, int end) {
		if (end < begin || begin < 0 || end == num.length) {
			return num.length;
		}
		int mid = (begin+end)/2;
		if (num[mid] <= k) {
			if (num[mid] == k && (mid == num.length-1 || num[mid+1] != k )) {
				return mid;
			}
			return getLast(num, k, mid+1, end);
		}else {
			return getLast(num, k, begin, mid-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 测试用例：
		 * 1. 目标值未出现过、一次、多次
		 * 2. 目标值为最小值，最大值，数组中只有一个数字
		 */
		int num[] = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
		S_38_NumberCount numberCount = new S_38_NumberCount();
		for (int i = 0; i < num.length; i++) {
			System.out.println(i + " : " + numberCount.get(num, i));
		}
	}

}
