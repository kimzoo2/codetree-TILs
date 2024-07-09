import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		int[] W = new int[n];
		int[] V = new int[n];

		for (int i = 0; i < n; i++) {
			String[] knapsackInformation = br.readLine().split(" ");
			W[i] = Integer.parseInt(knapsackInformation[0]);
			V[i] = Integer.parseInt(knapsackInformation[1]);
		}

		int[] dp = new int[m + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = m; j >= 0; j--) {
				if(dp[j] > -1){
					if(j + W[i] <= m){
						dp[j + W[i]] = Math.max(dp[j + W[i]], dp[j] + V[i]);
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= m; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
    }
}