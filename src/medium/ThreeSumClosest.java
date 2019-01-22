package medium;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosestFast(int[] nums, int target) {
		if(nums==null || nums.length==0)
			return 0;
		int len = nums.length;
		if(len<=3) {
			int sum = 0;
			for(int num : nums)
				sum+=num;
			return sum;
		}
		
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i<=len-3; i++) {
			int newTarget = target-nums[i];
			int low = i+1;
			int high = len-1;
			while(low<high) {
				int diff = nums[low]+nums[high]-newTarget;
				if(diff==0)
					return target;
				if(Math.abs(diff)<Math.abs(minDiff))
					minDiff = diff;
				if(diff>0)
					high--;
				else
					low++;
			}
		}
		
		return target+minDiff;
		
	}
	
	public int threeSumClosest(int[] nums, int target) {
		if(nums==null || nums.length==0)
			return 0;
		int len = nums.length;
		if(len<=3) {
			int sum = 0;
			for(int num : nums)
				sum+=num;
			return sum;
		}
		
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i<=len-3; i++)
			for(int j=i+1; j<=len-2; j++)
				for(int k=j+1; k<=len-1; k++) {
					int sum = nums[i]+nums[j]+nums[k];
					int diff = sum-target;
					if(diff==0)
						return target;
					if(Math.abs(diff)<Math.abs(minDiff))
						minDiff = diff;
				}
		
		return target+minDiff;
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ThreeSumClosest().threeSumClosestFast(new int[] {-1,1,3,2}, 1));
	}

}
