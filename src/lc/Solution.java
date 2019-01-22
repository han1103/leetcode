package lc;

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int index = 1;
        
        while(index<len) {
        	if (nums[index-1]==nums[index]) {
        		for(int i=index; i<len-1; i++)
        			nums[i]=nums[i+1];
        		len--;
        	}
        	else 
        		index++;
        }
        		
        return len;
    }
}