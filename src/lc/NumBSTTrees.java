package lc;

public class NumBSTTrees {

	public int numTrees(int n) {
		int[] nums = new int[n+1];
		
		nums[1]=1;
		for(int i=2; i<=n;  i++)
			for(int j=1; j<=i; j++) {
				if(j==i || j==1)
					nums[i]+=nums[i-1];
				else {
					nums[i]+=(nums[j-1]*nums[i-j]);
				}
			}
		
		return nums[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new NumBSTTrees().numTrees(3));

	}

}
