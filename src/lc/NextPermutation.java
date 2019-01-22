package lc;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length<2)
			return;
		
		for(int i=nums.length-2; i>=0; i--) {
			for(int j=nums.length-1; j>i; j--) {
				if(nums[i]<nums[j]) {
					int temp = nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
					for(int k=nums.length-1; k>(i+nums.length)/2; k--) {
						temp = nums[k];
						nums[k] = nums[i+nums.length-k];
						nums[i+nums.length-k] = temp;
					}
					return;
				}
			}
		}
		
		for(int i=0; i<=(nums.length-1)/2; i++) {
			int temp = nums[i];
			nums[i]=nums[nums.length-1-i];
			nums[nums.length-1-i] = temp;
		}
			
	}
	
	public static void main(String[] args) {
		//int[] nums = {61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46};
		//int[] nums = {59,58,57,56,55,54,53,52,51,50};
		//int[] nums = {9,8,7,6,5,4,3,2,1,0};
		int[] nums = {9,8,7,6,5,4};
		new NextPermutation().nextPermutation(nums);
		
		for(int num:nums)
			System.out.print(num+",");
		
		System.out.println();
	}

}
