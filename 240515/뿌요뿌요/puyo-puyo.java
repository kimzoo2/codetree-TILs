import java.io.*;
import java.util.*;
public class Main {
    private static int BLOCK_CNT = 0;
    static int[] nx = {-1, 0, 1, 0};
	static int[] ny = {0, 1, 0 ,-1};

	private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}
    private static void dfs(int[][] maps, boolean[][] checked, int x, int y, int target){
		for (int i = 0; i < 4; i++) {
			int newX = x + nx[i];
			int newY = y + ny[i];
			if(inRange(newX,newY,maps.length, maps.length) && !checked[newX][newY] && maps[newX][newY]==target){
				BLOCK_CNT++;
				checked[newX][newY] = true;
				dfs(maps, checked, newX, newY, target);
			}

		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] maps = new int[n][n];
		boolean[][] checked = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(split[j]);
			}
		}
		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!checked[i][j]) {
					BLOCK_CNT = 1;
					dfs(maps, checked, i, j, maps[i][j]);
					checked[i][j] = true;
					if(--BLOCK_CNT >= 4){
						cnt++;
					}
					ans = Math.max(ans, BLOCK_CNT);
				}
			}
		}

		System.out.println(cnt + " " + ans);
    }
}