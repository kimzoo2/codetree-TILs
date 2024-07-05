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
		int[][] dp = new int[n][2];
		dp[0][0] = arr[0][1];
		dp[0][1] = arr[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = arr[i][1];
			for (int j = i -1; j >= 0; j--) {
				// 기간이 겹치면서 큰 만족도를 주는 알바 여부
				if(arr[i][0] <= dp[j][0]) {
					dp[i][1] = Math.max(dp[i][1], Math.max(arr[i][2], dp[j][1]));
				}

				// 기간이 겹치지 않을 때
				if(arr[i][0] > dp[j][0]){
					// 기간이 겹치지 않을 때와 겹칠 때를 비교하여 pay가 더 큰 경우를 누적한다.
					dp[i][1] = Math.max(dp[i][1], arr[i][2] + dp[j][1]);
					break;
				}
			}

		}

		System.out.println(dp[n-1][1]);
    }
}