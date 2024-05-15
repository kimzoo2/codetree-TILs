import java.io.*;
import java.util.*;

public class Main {

    static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, 1, 0, -1};
	private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}

    private static int escapeMaze_priority(int[][] maps, boolean[][] checked){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0,0});
		checked[0][0] = true;
		int xLen = maps.length;
		int yLen = maps[0].length;

		while(!queue.isEmpty()){
			int[] ints = queue.poll();
			int x = ints[0];
			int y = ints[1];
			int distance = ints[2];

			if(x == xLen -1 && y == yLen-1){
				if(checked[x][y]) return distance;
				return -1;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dirX[i];
				int ny = y + dirY[i];

				if(inRange(nx, ny, xLen, yLen) &&
					!checked[nx][ny] &&
					maps[nx][ny] == 1){
					checked[nx][ny] = true;
					queue.add(new int[]{nx, ny, distance+1});
				}
			}
		}
		return -1;
	}

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int[][] maps = new int[n][m];
		boolean[][] checked = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] strings = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(strings[j]);
			}
		}

		System.out.println(escapeMaze_priority(maps, checked));
    }
}