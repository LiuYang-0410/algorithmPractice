package 剑指offer;

public class S_36_InversePairs {

	public static int count(int num[]) {
		return divide(num, 0, num.length-1);
	}
	
	public static int divide(int num[], int begin, int end) {
		if (begin >= end) {
			return 0;
		}
		int mid = (begin + end)/2;
		int leftCount = divide(num, begin, mid);
		int rightCount = divide(num, mid+1, end);
		return leftCount + rightCount + merge(num, begin, end);
	}
	
	public static int merge(int num[], int begin, int end) {
		int temp[] = new int[end-begin+1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = num[begin + i];
		}
		int inverseCount = 0, mid = (temp.length-1)/2;
		int index1 = mid, index2 = temp.length-1, origin = end;
		while (index1 >= begin && index2 > mid) {
			if (temp[index1] > temp[index2]) {//有逆序对
				inverseCount += index2 - mid;
				num[origin--] = temp[index1--];
			}else {
				num[origin--] = temp[index2--];
			}
		}
		while (index1 >= begin) {
			num[origin--] = temp[index1--];
		}
		while (index2 > mid) {
			num[origin--] = temp[index2--];
		}
		return inverseCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {7,5,6,4};
		System.out.println(count(num));
	}

}
