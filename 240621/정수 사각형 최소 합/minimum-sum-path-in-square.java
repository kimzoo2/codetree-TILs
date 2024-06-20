import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n + 2][n + 2];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				if (j + 1 <= n) {
					if (i - 1 >= 1) {
						dp[i][j] = Math.min(dp[i][j + 1], dp[i - 1][j]) + arr[i - 1][j - 1];
						continue;
					}else {
						dp[i][j] = dp[i][j + 1];
					}
				}
				if(i - 1 >= 1) {
					dp[i][j] = dp[i - 1][j];
				}

				dp[i][j] += arr[i - 1][j - 1];
			}
		}

		System.out.println(dp[n][1]);
    }
}