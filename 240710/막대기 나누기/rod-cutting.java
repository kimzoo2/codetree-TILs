import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] arr = new int[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(inputs[i]);
		}

		int[] dp = new int[n + 1];
		dp[1] = arr[1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(dp[i - j] + arr[j], arr[i]));
			}
		}

		System.out.println(dp[n]);
    }
}