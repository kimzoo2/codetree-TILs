import java.io.*;
import java.util.*;

public class Main {
    static int PERSON = 0;
	static ArrayList<Integer> PEOPLE = new ArrayList<>();
    static int[] nx = {-1, 0, 1, 0};
	static int[] ny = {0, 1, 0 ,-1};
    private static boolean inRange(int x, int y, int xLen, int yLen){
		return x >= 0 && x < xLen && y >= 0 && y < yLen;
	}
    private static int townArea(int[][] maps, boolean[][] checked, int x, int y, int cnt){
		int maxCnt = cnt;
		for (int i = 0; i < 4; i++) {
			int newX = x + nx[i];
			int newY = y + ny[i];
			if(inRange(newX, newY, maps.length, maps[0].length) && !checked[newX][newY] && maps[newX][newY] > 0){
				checked[newX][newY] = true;
				PERSON++;
				maxCnt = Math.max(maxCnt, townArea(maps, checked, newX, newY, cnt+1));
			}
		}
		return maxCnt;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] maps = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(split[j]);
			}
		}
		boolean[][] checked = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!checked[i][j] && maps[i][j] > 0) {
					checked[i][j] = true;
					PERSON = 1;
					townArea(maps, checked, i, j, 1);
					PEOPLE.add(PERSON);
				}
			}
		}

		Collections.sort(PEOPLE);

		System.out.println(PEOPLE.size());
		for (Integer person : PEOPLE) {
			System.out.println(person);
		}

    }
}