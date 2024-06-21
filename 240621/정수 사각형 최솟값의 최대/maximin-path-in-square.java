import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		dp[0][0] = arr[0][0];

		// dp 초기값 세팅하기
		for (int i = 1; i < n; i++) {
			// 가로 초기값
			dp[0][i] = Math.min(dp[0][i -1], arr[0][i]);

			// 세로 초기값
			dp[i][0] = Math.min(dp[i - 1][0], arr[i][0]);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				 dp[i][j] = Math.min(Math.max(dp[i-1][j], dp[i][j-1]), num[i][j]);
			}
		}

		System.out.println(dp[n - 1][n - 1]);
    }
}