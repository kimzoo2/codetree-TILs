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
			// 어제 화려함에 오늘 화려함을 더해서 가장 화려함이 큰 값을 누적한다.
			for (int j = 1; j <= n; j++) { // 현재 옷
				for (int k = 1; k <= n; k++) { // 어제 옷
					if(maps[k][i - 1] > 0 && maps[j][i] > 0) {
						dp[j][i] = Math.max(dp[j][i], dp[k][i - 1] + Math.abs(maps[j][i] - maps[k][i - 1]));
					}
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i][m]);
		}

		System.out.println(max);
    }
}