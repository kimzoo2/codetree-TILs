import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[2] = 1;
		if(n >= 3) {
			dp[3] = 1;
		}

		for (int i = 4; i <= n; i++) {
			dp[i] = (Math.max(dp[n-3], dp[n-2]) + 1) % 10_007;
		}

		System.out.println(dp[n]);
    }
}