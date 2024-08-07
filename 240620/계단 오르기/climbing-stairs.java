import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1000 + 1];
		dp[0] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 1;

		for (int i = 5; i <= n; i++) {
			dp[i] = (dp[i - 3] + dp[i - 2]) % 10_007;
		}

		System.out.println(dp[n]);
    }
}