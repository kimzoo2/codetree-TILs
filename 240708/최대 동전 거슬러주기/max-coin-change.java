import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		String[] tokenInputs = br.readLine().split(" ");
		int[] tokens = new int[n];
		int[] dp = new int[m + 1];

		Arrays.fill(dp, -1);

		for (int i = 0; i < n; i++) {
			tokens[i] = Integer.parseInt(tokenInputs[i]);
            if(tokens[i] > m){
				System.out.println(-1);
				return;
			}
			dp[tokens[i]] = 1;
		}

		for (int i = 0; i < n; i++) { // token 반복
			int token = tokens[i];
			for (int j = token + 1; j <= m; j++) { // 값 j의 동전횟수
				if(dp[j - token] > 0){
					dp[j] = Math.max(dp[j], dp[j - token] + 1);
				}
			}
		}

		System.out.println(dp[m]);
    }
}