package revisit;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	void backTracking(int[] candidates, int target, List<List<Integer>> answer, int currIndex, List<Integer> currList,
			int currSum) {
		if (currSum == target) {
			//answer.add(new ArrayList(currList));
			answer.add(currList);
		} else if (currSum < target) {
			for (int i = currIndex; i < candidates.length; i++) {
				List<Integer> newcurrList = new ArrayList(currList);
				newcurrList.add(candidates[i]);
				currSum += candidates[i];
				backTracking(candidates, target, answer, i, newcurrList, currSum);
				currSum -= candidates[i];
				//currList.remove(currList.size() - 1);
			}
		}
	}

	private void backtrack(int[] cand, List<List<Integer>> list, List<Integer> currList, int index, int remain) {
		if (remain == 0) {
			list.add(new ArrayList<>(currList));
		} else if (remain > 0) {
			for (int i = index; i < cand.length; i++) {
				currList.add(cand[i]);
				backtrack(cand, list, currList, i, remain - cand[i]);
				currList.remove(currList.size() - 1);
			}
		} // remain < 0, do nothing
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<>();
		backTracking(candidates, target, answer, 0, new ArrayList<Integer>(), 0);
		// backtrack(candidates, answer, new ArrayList<Integer>(), 0, target);

		return answer;
	}

	public static void main(String[] args) {
		List<List<Integer>> answer = new CombinationSum().combinationSum(new int[] { 2, 3, 6, 7 }, 7);

		for (List<Integer> list : answer) {
			for (int num : list)
				System.out.print(num + ",");
			System.out.println();
		}
	}
}
