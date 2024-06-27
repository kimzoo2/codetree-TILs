import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] length = br.readLine().split(" ");
		int n = Integer.parseInt(length[0]); // n = 옷 개수
		int m = Integer.parseInt(length[1]); // m = 총 일수
		int[][] maps = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String[] clothe = br.readLine().split(" ");
			int start = Integer.parseInt(clothe[0]);
			int end = Integer.parseInt(clothe[1]);
			int value = Integer.parseInt(clothe[2]);
			for (int j = start; j <= end; j++) {
				maps[i][j] = value;
			}
		}

		int[][] dp = new int[n + 1][m + 1];
		// i = 일자, j = 옷 번호
		for (int i = 2; i <= m; i++) {
			// 어제 제일 화려할 때를 찾는다.
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if(j == k || dp[k][i - 1] == 0) continue;
					dp[j][i] = Math.max(dp[j][i], dp[k][i - 1]);
				}
			}

			// |어제 - 오늘| 중 제일 큰 값을 dp에 누적한다.
			for (int j = 1; j <= n; j++) {
				int maxValue = 0;
				for (int k = 1; k <= n; k++) {
					if(maps[k][i - 1] > 0 && maps[j][i] > 0)
						maxValue = Math.max(maxValue, Math.abs(maps[j][i] - maps[k][i-1]));
				}
				dp[j][i] += maxValue;
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i][m]);
		}

		System.out.println(max);
    }
}