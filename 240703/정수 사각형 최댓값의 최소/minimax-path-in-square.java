import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] nums = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		int[][] dp = new int[n][n];
		dp[0][0] = nums[0][0];

		// initialize
		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.max(nums[0][i], dp[0][i - 1]);
			dp[i][0] = Math.max(nums[i][0], dp[i - 1][0]);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]);
				dp[i][j] = Math.max(dp[i][j], nums[i][j]);
			}
		}

		System.out.println(dp[n-1][n-1]);
	}
}