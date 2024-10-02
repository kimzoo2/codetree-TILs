import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static List<Location> chooseLocations = new ArrayList<>();
	private static int minDist = Integer.MAX_VALUE;
	private static int getDist(int x1, int x2, int y1, int y2) {
		return (int)(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}

	private static int getMaxDist() {
		int maxDist = 0;
		for (int i = 0; i < m - 1; i++) {
			Location aLocation = chooseLocations.get(i);
			for (int j = 0; j < m; j++) {
				if (i == j)
					continue;
				Location anotherLocation = chooseLocations.get(j);
				maxDist = Math.max(maxDist,
					getDist(aLocation.getX(), anotherLocation.getX(), aLocation.getY(), anotherLocation.getY()));
			}
		}
		return maxDist;
	}

	private static void backTracking(Location[] locations, int cnt, int idx) {
		// m개까지 차면 서로 가장 먼 거리 계산
		if (cnt == m) {
			minDist = Math.min(minDist, getMaxDist());
			return;
		}

		if(idx == n){
			return;
		}

		// 지금 좌표를 포함한다.
		chooseLocations.add(locations[idx]);
		backTracking(locations, cnt+1, idx+1);

		chooseLocations.remove(cnt);

		// 지금 좌표를 포함하지 않는다.
		backTracking(locations, cnt, idx+1);

	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]); // 모든 점의 개수
		m = Integer.parseInt(inputs[1]); // 골라야 하는 점의 개수

		Location[] locations = new Location[n];

		for (int i = 0; i < n; i++) {
			String[] dot = br.readLine().split(" ");
			locations[i] = new Location(Integer.parseInt(dot[0]), Integer.parseInt(dot[1]));
		}
		backTracking(locations, 0, 0);

		System.out.println(minDist);
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