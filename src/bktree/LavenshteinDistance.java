package bktree;

public class LavenshteinDistance {

	private String str;
	private int[][] dp;

	private static int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}

	public LavenshteinDistance(String str) {
		this.str = str;
		this.dp = new int[2][str.length() + 1];
	}

	public int getDistance(String str) {
		int len1 = this.str.length();
		int len2 = str.length();

		for (int i = 0; i <= len1; ++i) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= len2; ++i) {
			for (int j = 0; j <= len1; ++j) {
				if (j == 0) {
					dp[i % 2][j] = i;
				} else if (this.str.charAt(j - 1) == str.charAt(i - 1)) {
					dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
				} else {
					dp[i % 2][j] = 1 + min(
						dp[(i - 1) % 2][j],
						dp[i % 2][j - 1],
						dp[(i - 1) % 2][j - 1]
					);
				}
			}
		}

		return dp[len2 % 2][len1];
	}

	public static int getDistance(Object a, Object b) {
		return new LavenshteinDistance(a.toString()).getDistance(b.toString());
	}
}
