import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1000 + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 5; i <= n; i++) {
			if(i % 5 == 0){
				dp[i] = dp[i - 5] + 1;
			}
		}

		System.out.println(dp[n]);
    }
}