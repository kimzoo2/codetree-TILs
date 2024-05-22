import java.io.*;
import java.util.Stack;
public class Main {

    static int MAXLEN = 19;
	static int[][] maps = new int[MAXLEN][MAXLEN];
	static int[][][] memo = new int[MAXLEN][MAXLEN][4];
	static int[] dirX = {-1, 0, 1, 1};
	static int[] dirY = {1, 1, 1, 0};

	private static boolean inRange(int x, int y, int xLen, int yLen) {
		return x >= 0 && y >= 0 && x < xLen && y < yLen;
	}

	private static int calc(int x, int y, int dir, int color) {
		int nx = x + dirX[dir];
		int ny = y + dirY[dir];

		if (inRange(nx, ny, MAXLEN, MAXLEN) && maps[nx][ny] == color) {
			return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
		}
		return 1;
	}

    private static String findLocation() {
		for (int i = 0; i < MAXLEN; i++) { // 가로
			for (int j = 0; j < MAXLEN; j++) { // 세로
				if (maps[j][i] != 0)
					for (int d = 0; d < 4; d++) {
						if (memo[j][i][d] == 0 && calc(j, i, d, maps[j][i]) == 5) {
							return maps[j][i] + "\n" + (j + 1) + " " + (i + 1) + "\n";
						}
					}
			}
		}
		return "0";
	}
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < MAXLEN; i++) {
			String[] stones = br.readLine().split(" ");
			for (int j = 0; j < MAXLEN; j++) {
				maps[i][j] = Integer.parseInt(stones[j]);
			}
		}

		System.out.println(findLocation());
    }
}