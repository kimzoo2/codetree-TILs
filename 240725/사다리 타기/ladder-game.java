import java.io.*;
import java.util.*;
public class Main {

    private static int n,m,ans;
	private static int[] ansArr;

    private static int[] dirY = {1, -1};

	private static boolean inRange(int y, int yLen){
		return y >= 0 && y < yLen;
	}
	private static int[] ghostLeg(int[][] ladder) {
		int[] ans = new int[n];

		for (int i = 0; i < n; i++) {
			int x = 0;
			int y = i;
			while (true) {
				// 가로선이 있을 때만 방향을 튼다.
				if(ladder[x][y] > 0) {
					for (int j = 0; j < 2; j++) {
						int ny = y + dirY[j];
						// 짝이되는 가로선 방향으로 이동한다.
						if (inRange(ny, n) && ladder[x][ny] == ladder[x][y]) {
							y = ny;
							break;
						}
					}
				}
				x++;
				if (x == m) {
					ans[y] = i;
					break;
				}
			}
		}
		return ans;
	}

	private static boolean isSame(int[] newArr){
		for (int i = 0; i < n; i++) {
			if(newArr[i] != ansArr[i]) return false;
		}
		return true;
	}

	private static void drawLine(int[][] ladder, int a, int b, int cnt){
		if(isSame(ghostLeg(ladder))) {
			ans = Math.min(cnt, ans);
			return;
		}
		if(b == m){
			return;
		}

		// 선을 그었을 때
		ladder[b][a] = cnt + 1;
		ladder[b][a + 1] = cnt + 1;
		if(a + 3 < n) {
			drawLine(ladder, a + 2, b, cnt + 1);
		}else{
			drawLine(ladder, 0, b + 1, cnt + 1);
		}
		ladder[b][a] = 0;
		ladder[b][a + 1] = 0;
		// 선을 긋지 않았을 때
		if(a + 2 < n) {
			drawLine(ladder, a + 1, b, cnt);
		}else{
			drawLine(ladder, 0, b + 1, cnt);
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		ans = m;
		int[][] ladder = new int[m][n];

		for (int i = 1; i <= m; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]) - 1;
			int b = Integer.parseInt(ab[1]) - 1;
			ladder[b][a] = i;
			ladder[b][a + 1] = i;
		}
		ansArr = ghostLeg(ladder);

		ladder = new int[m][n];
		drawLine(ladder, 0, 0, 0);

		System.out.println(ans);

	}
}