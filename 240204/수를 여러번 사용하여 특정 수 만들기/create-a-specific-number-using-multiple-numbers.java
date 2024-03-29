import java.io.*;
public class Main {
    static int ANS = 0;
    public static void main(String[] args) throws IOException {
		//크기가 다른 정수 A, B, C가 주어집니다.
		// A와 B를 여러 번 사용할 수 있고 사용한 숫자들의 합이 C보다 작거나 같으면서 최대가 되도록 하는 프로그램을 작성해보세요.

		// 17 25 77
		// => 76

		// A+B+A <= 77
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		int c = Integer.parseInt(split[2]);

		int ans = 0;

		for(int i = 0; i * a <= c; i++) {
			int cnt = a * i;

			int numB = (c - cnt) / b;

			cnt += numB * b;

			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}

}