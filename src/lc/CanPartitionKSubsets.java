package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CanPartitionKSubsets {
	boolean canFind(List<Integer> list, int target, int startIndex, Stack<Integer> indexStack) {
		for (int i = startIndex; i >= 0; i--) {
			int num = list.get(i);
			if (num == target) {
				indexStack.push(i);
				return true;
			} else if (num < target) {
				indexStack.push(i);
				if (canFind(list, target - num, i - 1, indexStack))
					return true;
				else
					indexStack.pop();
			} else
				continue;
		}

		return false;
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length < 2)
			return false;

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % k != 0)
			return false;

		List<Integer> numList = new ArrayList<>();
		for (int num : nums)
			numList.add(num);

		Collections.sort(numList);

		int target = sum / k;
		if (numList.get(numList.size() - 1) > target)
			return false;

		for (int i = 0; i < k - 1; i++) {
			int startIndex = numList.size() - 1;
			Stack<Integer> indexStack = new Stack<>();
			if (canFind(numList, target, startIndex, indexStack)) {
				if (i == k-2)
					return true;
				else
					for(int j=0; j<indexStack.size(); j++) {
						int indexToRemove = indexStack.get(j); 
						numList.remove(indexToRemove);
					}
			} else
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CanPartitionKSubsets().canPartitionKSubsets(new int[] {10,10,10,7,7,7,7,7,7,6,6,6}
				, 3 ));
	}

}
