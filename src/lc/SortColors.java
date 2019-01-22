package lc;

public class SortColors {
	public void sortColorsSimple(int[] nums) {
		int num0=0;
		int num1=0;
		for(int num:nums)
			if(num==0)
				num0++;
			else if(num==1)
				num1++;
		int i=0;
		for(;i<num0; i++)
			nums[i]=0;
		for(;i<num0+num1;i++)
			nums[i]=1;
		for(;i<nums.length;i++)
			nums[i]=2;
	}
	
	public void sortColors(int[] nums) {
		int len = nums.length;
		for(int i=len-1; i>0; i--)
			for(int j=0; j<i; j++) {
				if (nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,0,2,1,1,0};
		new SortColors().sortColorsSimple(nums);
		for(int num : nums)
			System.out.print(num+",");
		System.out.println();
	}
}
