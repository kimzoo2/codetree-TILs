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

		int[] dp = new int[arr[n-1][1] + 1];
		dp[arr[0][1]] = arr[0][2];

		for (int i = 1; i < n; i++) {
			int start = arr[i][0];
			int end = arr[i][1];
			int value = arr[i][2];
			// 해당 알바와 기간이 겹치지만 더 큰 만족도를 주는 알바 여부
			for (int j = end; j >= start; j--) {
				dp[end] = Math.max(dp[end], Math.max(dp[j], value));
			}
			// 이전에 했던 알바와 누적 합산한다.
			for (int j = start-1; j >= 0 ; j--) {
				// 이전 알바가 있으나 기간이 겹쳐 0까지 가는 경우
				if(j == 0){
					dp[end] = Math.max(dp[end], value);
				}
				if(dp[j] > 0){
					dp[end] = Math.max(dp[end], dp[j] + value);
					break;
				}
			}
		}

		System.out.println(dp[arr[n-1][1]]);
    }
}