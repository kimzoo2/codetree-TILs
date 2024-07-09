import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		//5 12
		// 5 2 4 9 1
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		String[] numbers = br.readLine().split(" ");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(numbers[i]);
		}

		int[] dp = new int[m + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = m; j >= 0; j--) {
				if (dp[j] > -1) {
					if (nums[i] + j <= m) {
						dp[nums[i] + j] = dp[j] + 1;
					}
				}
			}
		}
		System.out.println(dp[m] == -1 ? "No" : "Yes");
    }
}