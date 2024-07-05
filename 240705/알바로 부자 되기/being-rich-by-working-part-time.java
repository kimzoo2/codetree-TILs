import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		Arrays.sort(arr, ((o1, o2) -> o1[1] - o2[1]));
		int[] dp = new int[n];
		// int[] dp = new int[arr[n-1][1] + 1];
		dp[0] = arr[0][2];

		for (int i = 1; i < n; i++) {
			for (int j = i -1; j >= 0; j--) {
				dp[i] = arr[i][2];
				// 기간이 겹치지 않을 때
				if(arr[i][0] > arr[j][1]){
					dp[i] = Math.max(dp[i], arr[i][2] + dp[j]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
    }
}