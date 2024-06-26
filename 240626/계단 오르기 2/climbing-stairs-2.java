import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[][] dp = new int[4][n + 1];

		String[] inputs = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(inputs[i - 1]);
		}

		dp[1][1] = arr[1];
		dp[0][2] = arr[2];
		dp[2][2] = arr[1] + arr[2];
		for (int i = 3; i <= n; i++) {
			for (int j = 0; j <= 3; j++) {
				if(j == 0 && dp[j][i - 2] > 0){
					dp[j][i] = dp[j][i - 2] + arr[i];
					continue;
				}
				if(j > 0 && dp[j - 1][i - 1] > 0) {
					dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j][i - 2]) + arr[i];
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= 3; i++) {
			max = Math.max(dp[i][n], max);
		}

		System.out.println(max);
	}
}