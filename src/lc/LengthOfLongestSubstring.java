package lc;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		if (s==null || s.length()==0)
			return 0;
		Set<Character> set = new HashSet<>();
		int maxLen = 0;
		for(int i=0; i<s.length(); i++) {			
			if(s.length()-i<=maxLen)
				return maxLen;			
			set.clear();
			for(int j=i; j<s.length(); j++) {
				char c = s.charAt(j);
				if (set.contains(c)) {					
					break;
				}
				else
					set.add(c);
			}
			maxLen = Math.max(maxLen, set.size());
		}
			
		return maxLen;	
	}
	
	public int lengthOfLongestSubstringWindow(String s) {
		if (s==null || s.length()==0)
			return 0;
		Set<Character> set = new HashSet<>();
		int maxLen = 1;

		set.add(s.charAt(0));
		int start=0;
		int end=1;
		while(end<s.length()) {
			if (s.length()-start<=maxLen)
				return maxLen;
			if(!set.contains(s.charAt(end))) {
				set.add(s.charAt(end));
				end++;
				maxLen = Math.max(maxLen, end-start);
			}
			else {
				set.remove(s.charAt(start));
				start++;				
				if(start==end) {
					set.add(s.charAt(start));
					end++;
				}
			}
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstringWindow("aaaa"));
	}

}
