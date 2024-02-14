import java.io.*;
public class Main {
    static int MAX_LEN = 100;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//좌표평면 위에 N개의 점이 있습니다. x축과 y축에 평행한 직선을 정확히 1개씩 그어 좌표평면을 4군데로 분할하여 균형 있게 나누려고합니다. 균형 있게 나눈다는 것은 4군데 중 가장 많은 점의 수가 최소가 되도록 하는 것을 의미합니다.
		//가장 많은 수의 점이 있는 구역의 점의 개수를 M이라고 할 때, 가능한 M의 최소값을 구하는 프로그램을 작성해보세요.
		// 단, x축과 y축에 평행한 직선은 항상 짝수에 그어집니다.

		//7
		// 7 3
		// 5 5
		// 9 7
		// 3 1
		// 7 7
		// 5 3
		// 9 1
		// => 2
		
		int cnt = Integer.parseInt(br.readLine());
		int[] x = new int[cnt];
		int[] y = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			String[] split = br.readLine().split(" ");
			x[i] = Integer.parseInt(split[0]);
			y[i] = Integer.parseInt(split[1]);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= MAX_LEN; i++) { // x
			for (int j = 1; j <= MAX_LEN; j++) { // y
				int sum = 0;
				int max = Integer.MIN_VALUE;
				boolean isOverlap = false;

				// 구간별 최대 점의 수를 구한다.
				for (int k = 0; k < cnt; k++) {
					if(x[k] > i && y[k] > j) sum++;
					if(x[k] == i || y[k] == j) isOverlap = true;
				}
				max = Math.max(max, sum);

				sum = 0;
				for (int k = 0; k < cnt; k++) {
					if(x[k] < i && y[k] > j) sum++;
					if(x[k] == i || y[k] == j) isOverlap = true;
				}
				max = Math.max(max, sum);

				sum = 0;
				for (int k = 0; k < cnt; k++) {
					if(x[k] < i && y[k] < j) sum++;
					if(x[k] == i || y[k] == j) isOverlap = true;
				}
				max = Math.max(max, sum);

				sum = 0;
				for (int k = 0; k < cnt; k++) {
					if(x[k] > i && y[k] < j) sum++;
					if(x[k] == i || y[k] == j) isOverlap = true;
				}
				max = Math.max(max, sum);

				if(isOverlap) continue;

				// 최대 점의 수 중에 최솟값을 구한다.
				min = Math.min(min, max);
			}
		}

		System.out.println(min);
    }
}