package lc;

public class LongestPalindrome {
	int expandFrom1Center(int i, String s) {
		int max = Math.min(i, s.length() - 1 - i);
		int l = 1;
		for (l = 1; l <= max; l++)
			if (s.charAt(i - l) != s.charAt(i + l)) {
				break;
			}

		return l - 1;
	}

	int expandFrom2Center(int i, String s) {
		int max = Math.min(i, s.length() - 2 - i);
		int l = 1;
		for (l = 1; l <= max; l++)
			if (s.charAt(i - l) != s.charAt(i + 1 + l)) {
				break;
			}

		return l - 1;
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int maxLenSoFar = 1;
		String maxLenStrSoFar = s.substring(0, 1);

		for (int i = 1; i < s.length() - 1; i++) {
			if (2 * Math.min(i, s.length() - 1 - i) + 1 <= maxLenSoFar)
				break;
			int radius = expandFrom1Center(i, s);
			if (2 * radius + 1 > maxLenSoFar) {
				maxLenSoFar = 2 * radius + 1;
				maxLenStrSoFar = s.substring(i - radius, i + radius + 1);
			}
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1))
				continue;
			if (i > s.length() / 2 && 2 * Math.min(i, s.length() - 2 - i) + 2 <= maxLenSoFar)
				break;
			int radius = expandFrom2Center(i, s);
			if (2 * radius + 2 > maxLenSoFar) {
				maxLenSoFar = 2 * radius + 2;
				maxLenStrSoFar = s.substring(i - radius, i + radius + 2);
			}
		}

		return maxLenStrSoFar;
	}

	Boolean[][] dp;
	int maxLeftIndex = 0;
	int maxRightIndex = 0;

	boolean findDP(String s, int i, int j) {
		if (dp[i][j] != null)
			return dp[i][j];
		if (findDP(s, i + 1, j - 1) == true && s.charAt(i) == s.charAt(j)) {
			dp[i][j] = true;
			if ((j - i) > (maxRightIndex - maxLeftIndex)) {
				maxLeftIndex = i;
				maxRightIndex = j;
			}
			return true;
		} else {
			dp[i][j] = false;
			return false;
		}
	}

	public String longestPalindromeDP(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int dim = s.length();

		dp = new Boolean[dim][dim];

		boolean foundTwo = false;
		for (int i = 0; i < dim; i++) {
			dp[i][i] = true;
			if (i < dim - 1)
				if (s.charAt(i) == s.charAt(i + 1)) {
					dp[i][i + 1] = true;
					if (!foundTwo) {
						maxLeftIndex = i;
						maxRightIndex = i + 1;
						foundTwo = true;
					} 
				}else {
						dp[i][i + 1] = false;
				}
		}

		for (int i = 0; i < dim; i++)
			for (int j = i + 2; j < dim; j++) {
				findDP(s, i, j);
			}

		return s.substring(maxLeftIndex, maxRightIndex + 1);
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindromeDP("aacdc"));

	}

}
