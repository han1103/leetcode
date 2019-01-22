package revisit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsetsRec(int[] nums, int index) {
		List<List<Integer>> answer = new ArrayList<>();
		if(index==0) {
			answer.add(new ArrayList<>());
			List<Integer> list = new ArrayList<>();
			list.add(nums[index]);
			answer.add(list);
			return answer;
		}
		List<List<Integer>> prevList = subsetsRec(nums, index-1);
		for(List<Integer> listItem : prevList) {
			List<Integer> temp = new ArrayList<>(listItem);
			answer.add(temp);
		}
		for(List<Integer> itemList : prevList) {
			itemList.add(nums[index]);
			answer.add(itemList);
		}
		return answer;
	}

	public List<List<Integer>> subsets1(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}	
	
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> currSet = new ArrayList<>();
		backtracking(answer, -1, nums, currSet);
		
		return answer;
	}
	
	private void backtracking(List<List<Integer>> answer, int currIndex, int[] nums, List<Integer> currSet) {
		answer.add(new ArrayList(currSet));
		for(int i=currIndex+1; i<nums.length; i++) {
			currSet.add(nums[i]);
			backtracking(answer, i, nums, currSet);
			currSet.remove(currSet.size()-1);
		}
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(new ArrayList<>());
		
		if(nums==null || nums.length==0)
			return answer;

		return subsetsRec(nums, nums.length-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> answer = new Subset().subsets2(new int[] {1,2,3});
		
		for(List<Integer> list :  answer) {
			for(int num : list)
				System.out.print(num+",");
			System.out.println();
		}
	}

}
