import java.io.*;
import java.util.*;
public class Main {
    static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] maps = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] map = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(map[j]);
			}
		}
		System.out.println(bfs(maps, visited));
    }
    private static boolean isRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}

	private static int bfs(int[][] maps, boolean[][] checked){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0});
		checked[0][0] = true;
		while(!queue.isEmpty()){
			int[] ints = queue.poll();
			int x = ints[0];
			int y = ints[1];
			if(maps.length-1 == x && maps[0].length-1 == y && maps[x][y] > 0){
				return 1;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dirX[i];
				int ny = y + dirY[i];
				if(isRange(nx, ny, maps.length, maps[0].length) && !checked[nx][ny] && maps[nx][ny] > 0){
					queue.add(new int[]{nx, ny});
					checked[nx][ny] = true;
				}
			}
		}

		return 0;
	}
}