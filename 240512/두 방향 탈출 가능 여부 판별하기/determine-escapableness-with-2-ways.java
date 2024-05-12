import java.io.*;
public class Main {
    static int[] nx = {1, 0};
	static int[] ny = {0, 1};

	private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}
	private static void escapeMaze(int[][] maps, boolean[][] checked, int x, int y){
		if(x == maps.length -1 && y == maps[0].length -1){
			return;
		}

		for (int i = 0; i < 2; i++) {
			int newX = x + nx[i];
			int newY = y + ny[i];
			if(inRange(newX, newY, maps.length, maps[0].length) && maps[newX][newY] == 1 && !checked[newX][newY]){
				checked[newX][newY] = true;
				escapeMaze(maps, checked, newX, newY);
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		int[][] maps = new int[n][m];
		boolean[][] checked = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(input[j]);
			}
		}
		escapeMaze(maps, checked, 0, 0);

		System.out.println(checked[n-1][m-1] ? 1 : 0);
    }
}