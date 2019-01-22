package lc;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsetsItr(int[] nums) {
		List<List<Integer>> retList = new ArrayList<>();
		
		List<Integer> listInt = new ArrayList<>();
		listInt.add(nums[0]);
		retList.add(listInt);
		
		for(int i=1; i<nums.length; i++) {
			List<List<Integer>> newRetList = new ArrayList<>();
			newRetList.addAll(retList);

			List<Integer> listItem = new ArrayList<>();
			listItem.add(nums[i]);
			newRetList.add(listItem);
			
			for(List<Integer> preItem : retList) {				
				List<Integer> currList = new ArrayList<>();
				for(Integer item : preItem)
					currList.add(item);
				currList.add(nums[i]);
				newRetList.add(currList);
			}			
			retList = newRetList;
		}
		
		return retList;
	}
	
	public List<List<Integer>> subsetsRec(int[] nums, int index) {
		List<List<Integer>> retList = new ArrayList<>();
		if(index==0) {
			List<Integer> listItem = new ArrayList<>();
			listItem.add(nums[0]);
			retList.add(listItem);
		}
		else {
			List<List<Integer>> preList = subsetsRec(nums, index-1);
			retList.addAll(preList);
/*			for(List<Integer> prevListItem : preList) {
				List<Integer> currList = new ArrayList<>();
				for(Integer item : prevListItem)
					currList.add(item);
				retList.add(currList);
			}
*/			
			List<Integer> listItem = new ArrayList<>();
			listItem.add(nums[index]);
			retList.add(listItem);
			
			for(List<Integer> preItem : preList) {				
				List<Integer> currList = new ArrayList<>();
				for(Integer item : preItem)
					currList.add(item);
				currList.add(nums[index]);
				retList.add(currList);
			}			
		}
		
		return retList;
			
	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> retList = new ArrayList<>();
		retList.add(new ArrayList<>());
		if (nums==null || nums.length==0)
			return retList;
				
		//retList.addAll(subsetsRec(nums, nums.length-1));
		retList.addAll(subsetsItr(nums));
		
		return retList;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> listOfList = new Subset().subsets(new int[] {1,2,3});
		
		for(List<Integer> item : listOfList) {
			for(int i:item)
				System.out.print(i+",");
			System.out.println();
		}
	}
}
