import java.io.*;
import java.util.Stack;

public class Main {

    static int MAXLEN = 19;
	static int[][] maps = new int[MAXLEN + 1][MAXLEN + 1];
	static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
	static int ans = 0;

	private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && y >= 0 && x < xLen && y < yLen;
	}

    private static boolean isSameStone(int x, int y){
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 8; i++) {
			int nx = x;
			int ny = y;
			stack.clear();
			stack.push(maps[x][y]);
			for (int j = 0; j < 4; j++) {
				nx += dirX[i];
				ny += dirY[i];
				int stone = stack.peek();
				if(inRange(nx, ny, MAXLEN, MAXLEN) && stone == maps[nx][ny]){
					stack.push(maps[nx][ny]);
				}
			}
			if(stack.size() == 5) return true;
		}
		return false;
	}

    private static int[] findLocation(){
		for (int i = 0; i < MAXLEN; i++) { // 가로
			for (int j = 0; j < MAXLEN; j++) { // 세로
				if(maps[j][i] != 0)
					if(isSameStone(j, i)){
						ans = maps[j][i];
						return new int[] {j, i};
					}
			}
		}
		return new int[]{};
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

		System.out.println(ans);
		if(ans > 0)
			System.out.println((location[0] + 1) + " " + (location[1] + 1));
    }
}