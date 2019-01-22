package medium;

public class RemoveDuplicates {
	void remove(int[] nums, int indexToRemove, int len) {
		for(int i=indexToRemove; i<len-1; i++) {
			nums[i] = nums[i+1];
		}
			
	}
	public int removeDuplicates(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		
		int len = nums.length;		
		
		int lastNum = Integer.MAX_VALUE;
		int repeat = 0;
		for(int i=0; i<len; i++) {
			if(nums[i]==lastNum) {
				if(repeat==2) {
					remove(nums, i, len);
					len--;
					i--;
				}
				else {
					repeat++;
				}
			}
			else {
				lastNum = nums[i];
				repeat = 1;
			}
		}
		
		return len;
	}
	
	public int removeDuplicatesFast(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		
		int len = nums.length;		
		
		int lastNum = Integer.MAX_VALUE;
		int repeat = 0;
		int pointer = -1;
		for(int i=0; i<len; i++) {
			if(nums[i]==lastNum) {
				if(repeat!=2) {
					repeat++;
					pointer++;
				}
			}
			else {
				lastNum = nums[i];
				repeat = 1;
				pointer++;
			}
			nums[pointer] = nums[i];
		}
		
		return pointer+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,1,1,1,2,3,3};
		//int[] nums = {1,1,1,1};
		
		System.out.println(new RemoveDuplicates().removeDuplicatesFast(nums));
		
		for(int num : nums)
			System.out.print(num+",");
		
		
		System.out.println();
	}

}
