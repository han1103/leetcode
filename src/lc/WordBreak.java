package lc;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s==null || s.length()==0)
			return true;
		for(String word : wordDict)
			if(s.length()>=word.length() && s.startsWith(word))
				if(wordBreak(s.substring(word.length()), wordDict))
					return true;
		
		return false;
	}
	
	public boolean wordBreakFast(String s, List<String> wordDict) {
		if(s==null || s.length()==0)
			return true;

		int num = s.length();
		boolean[] dp = new boolean[num+1];
		dp[0] = true;
		
		for(int i=1; i<num+1; i++)
			for(int j=0; j<i; j++) {
				if(dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		
		return dp[num];
	}
	
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		String s = "leetcode";
		System.out.println(new WordBreak().wordBreakFast(s, wordDict));

	}

}
