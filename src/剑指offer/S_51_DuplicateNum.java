package 剑指offer;

public class S_51_DuplicateNum {

	public int deduplicate(int num[]) {
		for (int i = 0; i < num.length; i++) {
			if (i == num[i]) 
				continue;
			if (num[i] == num[num[i]]) 
				return num[i];
			int temp = num[i];
			num[i] = num[num[i--]];
			num[temp] = temp;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {2,3,1,0,2,5,3};
		S_51_DuplicateNum duplicateNum = new S_51_DuplicateNum();
		System.out.println(duplicateNum.deduplicate(num));
	}

}
