package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return list;

		Arrays.sort(nums);

		int prev0 = Integer.MIN_VALUE;
		int prev1 = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				if (prev0 < nums[i] || prev1 < nums[j])
					for (int k = j + 1; k < nums.length; k++) {
						if (nums[i] + nums[j] + nums[k] == 0) {
							List<Integer> innerList = new ArrayList<>();
							innerList.add(nums[i]);
							innerList.add(nums[j]);
							innerList.add(nums[k]);
							list.add(innerList);
							if (nums[i] > prev0) {
								prev0 = nums[i];
								prev1 = nums[j];
							}
							if (nums[i]==prev0 && nums[j] > prev1)
								prev1 = nums[j];
							break;
						}
					}

		return list;
	}
}
