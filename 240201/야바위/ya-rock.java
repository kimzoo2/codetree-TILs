import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
		// 3개의 종이컵이 안쪽에 무엇이 들었는지 보이지 않도록 뒤집혀 있고, 셋 중 하나에 조약돌을 넣어 놓고 게임을 진행하려 합니다.
		// N번에 걸쳐 a번 종이컵과 b번 종이컵을 교환한 뒤,
		// c번 종이컵을 열어 그 안에 조약돌이 있으면 점수를 얻는 행동을 반복한다 할때,
		// 처음 조약돌을 어디에 넣어야 가장 높은 점수를 얻을 수 있는지를 계산하는 프로그램을 작성해보세요.

		// 3
		// 1 2 1
		// 3 2 1
		// 1 3 1
		// => 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			String[] strings = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strings[0]);
			arr[i][1] = Integer.parseInt(strings[1]);
			arr[i][2] = Integer.parseInt(strings[2]);
		}

		int ans = 0;
		for (int i = 1; i <= 3; i++) { // 조약돌 위치
			int[][] bucket = new int[1][4];
			bucket[0][i] = 1;
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				int a = arr[j][0];
				int b = arr[j][1];
				int c = arr[j][2];
				int temp = bucket[0][a];
				bucket[0][a] = bucket[0][b];
				bucket[0][b] = temp;
				if(bucket[0][c] > 0) cnt++;
			}
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}
}