package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums==null || nums.length<4)
			return list;
		int len = nums.length;
		
		Arrays.sort(nums);
		for(int i=0; i<=len-4; i++) {
			if(i>0 && nums[i-1]==nums[i])
				continue;
			for(int j=i+1; j<=len-3; j++) {
				if(j>i+1 && nums[j-1]==nums[j])
					continue;
				int low = j+1;
				int high = len-1;
				int prevMatchLow = -1;
				int prevMatchHigh = -1;
				while(low<high) {
					int sum = nums[i]+nums[j]+nums[low]+nums[high];
					if(sum==target && ( prevMatchLow==-1 || (nums[prevMatchLow]!=nums[low] || nums[prevMatchHigh]!=nums[high]) )  ) {
						List<Integer> matchingList = new ArrayList<>();
						matchingList.add(nums[i]);
						matchingList.add(nums[j]);
						matchingList.add(nums[low]);
						matchingList.add(nums[high]);
						list.add(matchingList);
						prevMatchHigh = high;
						prevMatchLow = low;
					}
					if(sum>=target) {
						high--;
					}
					else {
						low++;
					}
						
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new FourSum().fourSum(
				new int[] {5,5,3,5,1,-5,1,-2}, 4);
		
		System.out.println();
	}

}
