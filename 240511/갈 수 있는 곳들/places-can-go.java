import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int[][] maps = new int[n][n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			String[] map = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(map[j]);
			}
		}
		boolean[][] checked = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			String[] map = br.readLine().split(" ");
			ans += canGo(maps, Integer.parseInt(map[0])-1, Integer.parseInt(map[1])-1, checked);
		}

		System.out.println(ans);
    }

    private static int canGo(int[][] maps, int x, int y, boolean[][] checked){
		Queue<int[]> queue = new LinkedList<>();
		if(checked[x][y]){
			return 0;
		}
		queue.add(new int[] {x, y});
		checked[x][y] = true;
		int len = maps.length;
		int ans = 1;

		while(!queue.isEmpty()){
			int[] ints = queue.poll();
			int i = ints[0];
			int j = ints[1];

			for (int k = 0; k < 4; k++) {
				int ni = i + dirX[k];
				int nj = j + dirY[k];

				if(isRange(ni, nj, len, len) && !checked[ni][nj] && maps[ni][nj] == 0){
					queue.add(new int[]{ni,nj});
					checked[ni][nj] = true;
					ans++;
				}
			}
		}
		return ans;
	}

    private static boolean isRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}
}