import java.io.*;
public class Main {
	static int MAX_LEN_X = 10;
    static int MAX_LEN = 20;
	static int[] x = new int[MAX_LEN + 1];
	static int[] y = new int[MAX_LEN + 1];
    public static void main(String[] args) throws IOException {

		// 좌표평면 위에 서로 다른 N개의 점이 주어졌을 때,
		// x축 혹은 y축에 평행한 직선 3개로 주어진 모든 점들을 전부 지나게 할 수 있는지를 판단하는 프로그램을 작성해보세요.

		// 만약에 가로 혹은 세로 직선 3개로 모든 좌표를 지날 수 있다면 1을 출력합니다. 만약 직선 3개로 부족하다면 0을 출력합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());

		//6
		// 1 7
		// 0 0
		// 1 2
		// 2 0
		// 1 4
		// 3 4
		// => 1

		for (int i = 0; i < len; i++) {
			String[] split = br.readLine().split(" ");
			x[i] = Integer.parseInt(split[0]);
			y[i] = Integer.parseInt(split[1]);
		}

		int ans = 0;

		for (int i = 0; i <= MAX_LEN_X; i++) {
			for (int j = 0; j <= MAX_LEN_X; j++) {
				for (int k = 0; k <= MAX_LEN_X; k++) {
					boolean success = true;

					for (int l = 0; l < len; l++) {
						if(x[l] == i || x[l] == j || x[l] == k)
							continue;
						success = false;
					}
					if(success)
						ans = 1;

					success = true;
					for(int l = 0; l < len; l++) {
						if(x[l] == i || x[l] == j || y[l] == k)
							continue;

						success = false;
					}
					
					if(success)
						ans = 1;

					success = true;
					for(int l = 0; l < len; l++) {
						if(x[l] == i || y[l] == j || y[l] == k)
							continue;

						success = false;
					}
					if(success)
						ans = 1;

					success = true;
					for(int l = 0; l < len; l++) {
						if(y[l] == i || y[l] == j || y[l] == k)
							continue;

						success = false;
					}
					if(success)
						ans = 1;
				}
			}
		}

		// 맞는지 확인하기
		System.out.println(ans);
    }
}