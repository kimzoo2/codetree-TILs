import java.io.*;
import java.util.*;

public class Main {
    static int[] nx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] ny = {1, 2, 2, 1, -1, -2, -2, -1};

    private static boolean inRange(int x, int y, int xLen, int yLen){
		return x > 0 && x < xLen && y > 0 && y < yLen;
	}

	private static int knight_bfs(int n, int x1, int y1, int x2, int y2){
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] checked = new boolean[n][n];
		checked[x1][y1] = true;
		queue.add(new int[]{x1,y1,0});

		while(!queue.isEmpty()){
			int[] ints = queue.poll();
			int x = ints[0];
			int y = ints[1];
			int distance = ints[2];

			if(x== x2 && y == y2) return distance;

			for (int i = 0; i <8; i++) {
				int newX = x + nx[i];
				int newY = y + ny[i];

				if(inRange(newX, newY, n, n) &&!checked[newX][newY]){
					checked[newX][newY] = true;
					queue.add(new int[] {newX, newY, distance+1});
				}
			}
		}

		return -1;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int x1 = Integer.parseInt(split[0]);
		int y1 = Integer.parseInt(split[1]);
		int x2 = Integer.parseInt(split[2]);
		int y2 = Integer.parseInt(split[3]);

		System.out.println(knight_bfs(n+1, x1, y1, x2, y2));
    }
}