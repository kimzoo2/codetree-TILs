import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws IOException {
		// 1차 수직선 상에 T개의 알파벳이 놓여있습니다.
		// 알파벳은 S, N으로만 주어지며,
		// 특정 위치 x = k로부터 가장 가까이에 있는 알파벳 S까지의 거리 d1이
		// x = k로부터 가장 가까이에 있는 알파벳 N까지의 거리 d2보다 같거나 작은 경우 x = k는 특별한 위치가 됩니다.
		// x = a부터 x = b까지의 위치 중 특별한 위치의 수를 구하는 프로그램을 작성해보세요.


		// 첫 번째 줄에 T, a, b가 공백을 사이에 두고 주어집니다.
		// 두 번째 줄부터는 T개의 줄에 걸쳐 각 알파벳 값 c와 해당 알파벳이 놓여있는 위치 x값이 공백을 사이에 두고 주어집니다.

		// 3 1 10
		// S 10
		// N 4
		// S 1
		// => 6

		// d1(S까지의 거리) <= d2(N까지의 거리) => 특별한 위치
		// S 0 0 N 0 0 0 0 0 S
		// x = 1, 2, 7, 8, 9, 10이 특별한 위치

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int t = Integer.parseInt(input[0]); // 3
		int a = Integer.parseInt(input[1]); // 1
		int b = Integer.parseInt(input[2]); // 10

		Info[] infos = new Info[t];
		for (int i = 0; i < t; i++) {
			String[] strings = br.readLine().split(" ");
			char alpha = strings[0].charAt(0);
			int idx = Integer.parseInt(strings[1]);
			infos[i] = new Info(alpha, idx);
		}

		Arrays.sort(infos);
		int ans = 0;

		for (int i = a; i <= b; i++) {
			// S까지의 거리
			int d1 = Integer.MAX_VALUE;
			int d2 = Integer.MAX_VALUE;
			for (int j = 0; j < t; j++) {
				int abs = Math.abs(i - infos[j].getIdx());
				if(infos[j].getAlpha() == 'S')
					d1 = Math.min(d1, abs);
				else
					d2 = Math.min(d2, abs);
			}

			if(d1 <= d2) ans++;
		}

		System.out.println(ans);
	}

	static class Info implements Comparable<Info>{
		char alpha;
		int idx;

		public Info(char alpha, int idx) {
			this.alpha = alpha;
			this.idx = idx;
		}

		public char getAlpha() {
			return alpha;
		}

		public int getIdx() {
			return idx;
		}

		@Override
		public int compareTo(Info o) {
			return this.idx - o.idx;
		}
	}
}