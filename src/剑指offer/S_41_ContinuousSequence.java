package 剑指offer;

public class S_41_ContinuousSequence {

	public void find(int target) {
		int i = 1, j = 2,sum = 3;
		while (i < j) {
			if (sum == target ) {
				print(i, j);
				sum -= i++;
			}else if (sum < target) {
				sum += ++j;
			}else {
				sum -= i++;
			}
		}
	}
	
	private void print(int begin, int end) {
		for (int i = begin; i <= end; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S_41_ContinuousSequence continuousSequence = new S_41_ContinuousSequence();
		continuousSequence.find(15);
	}

}
