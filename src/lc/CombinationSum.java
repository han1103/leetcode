package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	void combinationRec(int[] candidates, int index, int target, Stack<Integer> comb) {
		int candidate = candidates[index];
		if (index == 0) {
			if (target % candidate == 0) {
				int numRepeats = target / candidate;
				List<Integer> combCopy = new ArrayList<>();
				combCopy.addAll(comb);
				for (int i = 0; i < numRepeats; i++)
					combCopy.add(candidate);
				result.add(combCopy);
			}
			return;
		}

		if (candidate <= target) {
			int i = 1;
			while (i * candidate <= target) {
				for (int j = 1; j <= i; j++)
					comb.push(candidate);
				if (i * candidate == target) {
					List<Integer> combCopy = new ArrayList<>();
					combCopy.addAll(comb);
					for (int j = 1; j <= i; j++)
						comb.pop();
					result.add(combCopy);
					break;
				} else {
					combinationRec(candidates, index - 1, target - i * candidate, comb);
					for (int j = 1; j <= i; j++)
						comb.pop();
				}
				i++;
			}
		}
		if (index >= 1)
			combinationRec(candidates, index - 1, target, comb);

	}

	void combineRec(int[] candidates, int index, int target, Stack<Integer> currList) {
		for (int i = index; i >= 0; i--) {
			if (candidates[i] <= target) {
				int candidate = candidates[i];
				currList.push(candidate);
				if (target == candidate) {
					List<Integer> currListCopy = new ArrayList<>();
					currListCopy.addAll(currList);
					result.add(currListCopy);
				} else if (target > candidate) {
						combineRec(candidates, i, target-candidate, currList);
				}
				currList.pop();
			}
		}
	}

	public List<List<Integer>> combinationSumNewIdea(int[] candidates, int target) {
		if (candidates != null && candidates.length != 0) {
			Arrays.sort(candidates);

			for (int k = candidates.length - 1; k >= 0; k--) {
				if (candidates[k] <= target) {
					combineRec(candidates, k, target, new Stack<>());
					break;
				}
			}

		}

		return result;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		if (candidates != null && candidates.length != 0) {
			Arrays.sort(candidates);

			for (int k = candidates.length - 1; k >= 0; k--) {
				int candidate = candidates[k];
				if (candidate <= target) {
					int i = 1;
					while (i * candidate <= target) {
						Stack<Integer> comb = new Stack<>();
						for (int j = 1; j <= i; j++)
							comb.push(candidate);
						if (target == i * candidate) {
							result.add(comb);
							break;
						}
						if (k >= 1)
							combinationRec(candidates, k - 1, target - i * candidate, comb);
						i++;
					}
					Stack<Integer> comb = new Stack<>();
					if (k >= 1)
						combinationRec(candidates, k - 1, target, comb);
					break;
				}
			}
		}
		return result;
	}

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSumDiscussion(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<>();
		backtrack(candidates, list, new ArrayList<>(), 0, target);
		return list;
	}

	// if remain == 0: list.add(currList)
	// for each element in cand, if (cand[i] <= remain): currList + cand[i], then
	// backtrack (i, target - cand[i])
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

	public static void main(String[] args) {
		List<List<Integer>> result = new CombinationSum().combinationSumNewIdea(new int[] { 2, 5, 3 }, 9);

		for (List<Integer> list : result) {
			for (int num : list)
				System.out.print(num + ",");
			System.out.println();
		}
	}

}
