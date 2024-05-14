import java.io.*;
import java.util.*;
public class Main {
    static int[] nx = {-1, 0, 1, 0};
	static int[] ny = {0, 1, 0 ,-1};
    static int MAXLEN = 100;
    private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}
	private static void safeArea(int[][] maps, boolean[][] checked, int x, int y, int k){
		for (int i = 0; i < 4; i++) {
			int newX = x + nx[i];
			int newY = y + ny[i];
			if(inRange(newX, newY, maps.length, maps[0].length) && maps[newX][newY] > k && !checked[newX][newY]){
				checked[newX][newY] = true;
				safeArea(maps, checked, newX, newY, k);
			}
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strings = br.readLine().split(" ");
		int n = Integer.parseInt(strings[0]);
		int m = Integer.parseInt(strings[1]);
		int[][] maps = new int[n][m];
		boolean[][] checked = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(split[j]);
			}
		}

		int[] ans = new int[2];
        ans[0] = 1;
		for (int i = 1; i < MAXLEN; i++) {
			int areaCnt = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(!checked[j][k] && maps[j][k] > i) {
						safeArea(maps, checked, j, k, i);
						areaCnt++;
					}
				}
			}
			if(areaCnt > ans[1]){
				ans[0] = i;
				ans[1] = areaCnt;
			}
			checked = new boolean[n][m];
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}