import java.io.*;
import java.util.*;
public class Main {

    private static int n, max;
    public static List<Location> chooseLocations = new ArrayList<>();
    private static boolean canAdd(int x, int y){
		for (Location location : chooseLocations) {
			if(location.getX() == x || location.getY() == y) return false;
		}
		return true;
	}

	private static int getMax(int[][] map){
		int min = Integer.MAX_VALUE;
		for (Location location : chooseLocations) {
			min = Math.min(min, map[location.getX()][location.getY()]);
		}
		return min;
	}

	private static void getMax(int[][] map, int cnt, int y) {
		if (chooseLocations.size() == n) {
			// min 값과 비교하여 max 값을 구한다.
			max = Math.max(max, getMax(map));
			return;
		}

		if (y == n) {
			return;
		}

		// 현재 위치를 선택한다.
		// 같은 행, 열을 확인한다.
		for (int i = 0; i < n; i++) {
			if(canAdd(i, y)) {
				chooseLocations.add(new Location(i, y));
				getMax(map, cnt + 1, y + 1);
				chooseLocations.remove(cnt);
			}
		}

	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		getMax(map, 0, 0);

		System.out.println(max);
	}
}

class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Location{" +
			"x=" + x +
			", y=" + y +
			'}';
	}
}