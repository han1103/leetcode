package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CanPartition {

	Boolean[] canPart = null;
/*	boolean canPartition(int[] nums, int target, Set<Integer> usedIndexes) {
		for(int i=0; i<nums.length; i++) {
			if(usedIndexes.contains(i))
				continue;
			int num = nums[i];
			if(num==target)
				return true;
			else if(num<target) {
				Boolean canPartValue = canPart[target-num];
				if(canPartValue!=null && !canPartValue)
					continue;
				usedIndexes.add(i);
				if(canPartition(nums, target-num, usedIndexes))
					return true;
				usedIndexes.remove(i);
			}
			else
				break;					
		}
		return false;
		
	}
*/	
	boolean canPartition(int[] nums, int target, Set<Integer> usedIndexes) {
		for(int i=0; i<nums.length; i++) {
			if(usedIndexes.contains(i))
				continue;
			int num = nums[i];
			if(num==target)
				return true;
			else if(num<target) {
				usedIndexes.add(i);
				if(canPartition(nums, target-num, usedIndexes))
					return true;
				usedIndexes.remove(i);
			}
			else
				break;					
		}
		return false;
		
	}	
	
	boolean canPartitionStack(int[] nums, int target, Stack<Integer> usedIndexes) {
		for(int i=0; i<nums.length; i++) {
			if(usedIndexes.contains(i))
				continue;
			int num = nums[i];
			if(num==target)
				return true;
			else if(num<target) {
				usedIndexes.push(i);
				if(canPartitionStack(nums, target-num, usedIndexes))
					return true;
				usedIndexes.pop();
			}
			else
				break;					
		}
		return false;
		
	}

	boolean canPartitionFind(int[] nums, int target, int index, Stack<Integer> stack) {
		for(int i=index; i>=0; i--) {
			int num = nums[i];
			if(num==target) {
				stack.push(num);
				return true;
			}
			else if(num<target) {
				stack.push(num);
				if(canPartitionFind(nums, target-num, i-1, stack))
					return true;
				stack.pop();
			}
			else
				continue;					
		}
		return false;
		
	}

	boolean canPartitionRec(int[] nums, int target, int index) {
		for(int i=index; i>=0; i--) {
			int num = nums[i];
			if(num==target)
				return true;
			else if(num<target) {
				if(canPartitionRec(nums, target-num, i-1))
					return true;
			}
			else
				continue;					
		}
		return false;
		
	}

	boolean canPartitionRecEasy(int[] nums, int target, int index) {
		for(int i=index; i>=0; i--) {
			int num = nums[i];
			if(num==target)
				return true;
			else if(num<target) {
				if(canPartitionRec(nums, target-num, i-1))
					return true;
			}
			else
				continue;					
		}
		return false;
		
	}

	public boolean canPartition(int[] nums) {
		if(nums==null || nums.length<2)
			return false;
		
		int sum = 0;
		for(int num : nums)
			sum+=num;
		
		if(sum%2==1)
			return false;
				
		Arrays.sort(nums);
		
		if(nums[nums.length-1]>sum/2)
			return false;
		//canPart = new Boolean[sum/2];
		
		//return canPartition(nums, sum/2, new HashSet<>());
		//return canPartitionRec(nums, sum/2, nums.length-1);
		//return canPartitionStack(nums, sum/2, new Stack());
		Stack<Integer> stack = new Stack<>();
		if(canPartitionFind(nums, sum/2, nums.length-1, stack)) {
			for(int num : stack)
				System.out.print(num+",");
			return true;	
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(new CanPartition().canPartition(new int[] {6,2,3,5}));
		System.out.println(new CanPartition().canPartition(new int[] {6,2,3,5}));
		/*System.out.println(new CanPartition().canPartition(new int[] {
		1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100
				}));*/
	}

}
