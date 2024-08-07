import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		if(n >= 2){
			dp[2] = 2;
		}

		for (int i = 3; i <= n; i++) {
            int num = 0;
			num = dp[i - 1] + dp[i - 2] ;

			if(i >= 5){
				num += dp[i - 5];
			}
            dp[i] = num % 10_007;
		}

		System.out.println(dp[n]);
    }
}