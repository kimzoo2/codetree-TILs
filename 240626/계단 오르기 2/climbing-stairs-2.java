import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] dp = new int[4][n + 2];

		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}

		dp[1][n] = arr[n - 1];
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= 3; j++) {
				if(dp[j - 1][i + 1] > 0 || dp[j][i + 2] > 0) {
					dp[j][i] = Math.max(dp[j - 1][i + 1], dp[j][i + 2]) + arr[i - 1];
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				max = Math.max(dp[i][j], max);
			}
		}

		System.out.println(max);
    }
}