import java.io.*;
import java.util.Stack;
public class Main {

    static int MAXLEN = 19;
	static int[][] maps = new int[MAXLEN][MAXLEN];
	static boolean[][] checked = new boolean[MAXLEN][MAXLEN];
	static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
	static int ANS = 0;
	static int DIR = 0;

	private static boolean inRange(int x, int y, int xLen, int yLen) {
		return x >= 0 && y >= 0 && x < xLen && y < yLen;
	}

	private static boolean isSameStone(int x, int y) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 8; i++) {
			if(i == 7) continue;
			int nx = x;
			int ny = y;
			stack.clear();
			stack.push(maps[x][y]);
			int dir = (i + 4) % 8;
			int bfX = x + dirX[dir];
			int bfY = y + dirY[dir];
			// 최초 돌만 확인한다
			if (inRange(bfX, bfY, MAXLEN, MAXLEN) && maps[bfX][bfY] == maps[nx][ny])
				continue;

			for (int j = 0; j < 6; j++) {
				nx += dirX[i];
				ny += dirY[i];
				int stone = stack.peek();
				if (inRange(nx, ny, MAXLEN, MAXLEN) && stone == maps[nx][ny]) {
					stack.push(maps[nx][ny]);
				} else {
					break;
				}
			}
			if (stack.size() == 5) {
				DIR = i;
				return true;
			}
		}
		return false;
	}

    private static int[] findLocation() {
		for (int i = 0; i < MAXLEN; i++) { // 가로
			for (int j = 0; j < MAXLEN; j++) { // 세로
				if (maps[i][j] != 0)
					if (isSameStone(i, j)) {
						ANS = maps[i][j];
						return new int[] {i, j};
					}
			}
		}
		return new int[] {};
	}
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < MAXLEN; i++) {
			String[] stones = br.readLine().split(" ");
			for (int j = 0; j < MAXLEN; j++) {
				maps[i][j] = Integer.parseInt(stones[j]);
			}
		}

		int[] location = findLocation();
		System.out.println(ANS);
		int x = location[0] + 1;
		int y = location[1] + 1;
		if (ANS > 0 && DIR > 4) {
			for (int i = 0; i < 4; i++) {
				x += dirX[DIR];
				y += dirY[DIR];
			}
		}
		System.out.println(x + " " + y);
    }
}