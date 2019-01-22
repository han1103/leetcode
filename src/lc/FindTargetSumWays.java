package lc;

public class FindTargetSumWays {
	int TARGET;
	int MAX;
	int total=0;
	Integer[][] cache;
	
	void match(int[] nums, int index, int target) {
		if(index==0) {
			if(nums[0]==target)
				total++;
			if(nums[0]==-target)
				total++;
			return;
		}
		match(nums, index-1, target+nums[index]);
		match(nums, index-1, target-nums[index]);
	}

	Integer matchCached(int[] nums, int index, int target) {
		int result = 0;
		if(index==0) {
			if(nums[0]==target) {
				result++;
			}			
			if(nums[0]==-target) {
				result++;
			}
			return result;
		}
		int nextTarget = target+nums[index];
		if (cache[index-1][nextTarget+MAX-TARGET] == null)
			cache[index-1][nextTarget+MAX-TARGET] = matchCached(nums, index-1, nextTarget);
		result += cache[index-1][nextTarget+MAX-TARGET];
			
		nextTarget = target-nums[index];
		if (cache[index-1][nextTarget+MAX-TARGET] == null)
			cache[index-1][nextTarget+MAX-TARGET] = matchCached(nums, index-1, nextTarget);
		result += cache[index-1][nextTarget+MAX-TARGET];
		
		return result;
	}

	public int findTargetSumWays(int[] nums, int S) {
		TARGET = S;
		for(int num : nums)
			MAX += num;

		cache = new Integer[nums.length][2*MAX+1];
		
		//match(nums, nums.length-1, S);		
		//return total;
		return matchCached(nums, nums.length-1, S);
	}
	
	public static void main(String[] args) {
		System.out.println(new FindTargetSumWays().findTargetSumWays(new int[] 
				{1,2,7,9,1000000000}, 
				1000000000));
		
	}

}
