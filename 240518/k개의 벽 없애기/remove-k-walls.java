import java.io.*;
import java.util.*;
public class Main {

    static int MIN_DISTANCE = Integer.MAX_VALUE;
	static int[] start_arr = new int[2];
	static int[] end_arr = new int[2];
    static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, 1, 0, -1};

	private static boolean inRange(int x, int y, int xLen, int yLen) {
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}

    public static void crashWall_bfs(int[][] maps, int n) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] checked = new boolean[n][n];
		queue.add(new int[] {start_arr[0], start_arr[1], 0});
		checked[start_arr[0]][start_arr[1]] = true;

		while (!queue.isEmpty()) {
			int[] ints = queue.poll();
			int x = ints[0];
			int y = ints[1];
			int distance = ints[2];

			if (end_arr[0] == x && end_arr[1] == y) {
				MIN_DISTANCE = Math.min(MIN_DISTANCE, distance);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dirX[i];
				int ny = y + dirY[i];

				if (inRange(nx, ny, n, n) && !checked[nx][ny] && maps[nx][ny] == 0) {
					checked[nx][ny] = true;
					queue.add(new int[] {nx, ny, distance + 1});
				}
			}
		}
	}

    public static void crashWall_dfs(int[][] maps, boolean[][] checked, int x, int y, int n, int k){
		if(k == 0) crashWall_bfs(maps, n);
		for (int i = 0; i < 4; i++) {
			int nx = x + dirY[i];
			int ny = y + dirY[i];
			if(inRange(nx, ny, n, n) && maps[nx][ny] == 1 && !checked[nx][ny]){
				maps[nx][ny] = 0;
				checked[nx][ny] = true;
				crashWall_dfs(maps, checked, nx, ny, n, k-1);
				maps[nx][ny] = 1;
				checked[nx][ny] = false;
			}
		}
	}

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);
		int[][] maps = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] map = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(map[j]);
			}
		}

		String[] start = br.readLine().split(" ");
		String[] end = br.readLine().split(" ");
		start_arr[0] = Integer.parseInt(start[0])-1;
		start_arr[1] = Integer.parseInt(start[1])-1;
		end_arr[0] = Integer.parseInt(end[0])-1;
		end_arr[1] = Integer.parseInt(end[1])-1;
		boolean[][] checked = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				crashWall_dfs(maps, checked, i, j, n, k);
			}
		}

		System.out.println(MIN_DISTANCE == Integer.MAX_VALUE ? -1 : MIN_DISTANCE);
    }
}