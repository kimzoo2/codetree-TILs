import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		// jump : 이동 하려는 블록
		// i : 현재 블록

		// 조건
		// 1) map[jump] > map[i]
		// 2) jump > i, jump > j

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] length = br.readLine().split(" ");
		int n = Integer.parseInt(length[0]);
		int m = Integer.parseInt(length[1]);
		int[][] maps = new int[n][m];
		int[][] memo = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		memo[0][0] = maps[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				canJump(maps, memo, i, j);
			}
		}

		int max = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				max = Math.max(max, memo[i][j]);
			}
		}

		System.out.println(max);
	}

	private static void canJump(int[][] maps, int[][] memo, int x, int y){
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(maps[i][j] < maps[x][y]){
					memo[x][y] = Math.max(memo[x][y], memo[i][j] + 1);
				}
			}
		}
	}
}