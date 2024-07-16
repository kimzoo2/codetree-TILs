import java.io.*;
public class Main {

    static int n;
    static int CNT;
	static int ANS;

    static int[][][] bombPoint = {{{-2, 0},{-1, 0}, {0,0}, {1, 0}, {2, 0}},
							{{-1, 0}, {0, 1}, {0, 0}, {1, 0}, {0, -1}},
							{{-1, 1}, {1, 1}, {0, 0}, {1, -1}, {-1, -1}}};
	
	private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}
	private static void explode(int x, int y, int idx, int[][] checked){
		for (int i = 0; i < 5; i++) {
			int nx = x + bombPoint[idx][i][0];
			int ny = y + bombPoint[idx][i][1];
			if(inRange(nx, ny, n, n)){
				checked[nx][ny]++;
			}
		}
	}

	private static void reset(int x, int y, int idx, int[][] checked){
		for (int i = 0; i < 5; i++) {
			int nx = x + bombPoint[idx][i][0];
			int ny = y + bombPoint[idx][i][1];
			if(inRange(nx, ny, n, n)){
				checked[nx][ny]--;
			}
		}
	}

	private static void dfs(int cnt, int[][] checked, int[][] maps){
		if(CNT == cnt){
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(checked[i][j] > 0) ans++;
				}
			}
			ANS = Math.max(ANS, ans);
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(maps[i][j] == 1){
					for (int k = 0; k < 3; k++) {
						maps[i][j] = 0;
						explode(i, j, k, checked);
						dfs(cnt + 1, checked, maps);
						reset(i, j, k, checked);
						maps[i][j] = 1;
					}
				}
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] maps = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(inputs[j]);
				if(maps[i][j] == 1) CNT++;
			}
		}

		int[][] checked = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(maps[i][j] == 1){
					for (int k = 0; k < 3; k++) {
						maps[i][j] = 0;
						explode(i, j, k, checked);
						dfs(1, checked, maps);
						checked = new int[n][n];
					}
					break;
				}
			}
		}

		System.out.println(ANS);
    }
}