import java.io.*;
import java.util.*;

public class Main {

    static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, 1, 0, -1};
	private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}

    private static void avoidTheRain_bfs(int[][] maps, int[][] ans, int x, int y, int len) {
		boolean[][] checked = new boolean[len][len];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,0});
		checked[x][y] = true;

		while(!queue.isEmpty()){
			int[] ints = queue.poll();
			int qx = ints[0];
			int qy = ints[1];
			int distance = ints[2];

			if(maps[qx][qy] == 3){
				ans[x][y] = distance;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = qx + dirX[i];
				int ny = qy + dirY[i];
				if(inRange(nx, ny, len, len) && maps[nx][ny] != 1 && !checked[nx][ny]){
					checked[nx][ny] = true;
					queue.add(new int[]{nx, ny, distance+1});
				}
			}
		}
	}

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int h = Integer.parseInt(inputs[1]);
		int m = Integer.parseInt(inputs[2]);
		int[][] maps = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] map = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(map[j]);
			}
		}
		int[][] ans = new int[n][n];


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(maps[i][j] == 2) {
					avoidTheRain_bfs(maps, ans, i, j, n);
					if(ans[i][j] == 0) ans[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
    }
}