import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[1000 + 1];

		dp[1] = 2;
		dp[2] = 7;
		dp[3] = 22;
		// dp[4] = 71;
		// dp[5] = 228;
		// dp[6] = 733;
		

		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 1] * 3 + dp[i - 2] - dp[i - 3]) % 1_000_000_007;
		}

		System.out.println(dp[n]);
    }
}