import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

		//두 개의 정수 X, Y가 주어지면 X이상 Y이하의 값 중 팰린드롬의 개수를 세려고합니다.
		//여기서 말하는 팰린드롬은 거꾸로 읽어도 제대로 읽는 것과 같은 수를 말합니다.
		//예를 들어 34543이나, 9009등이 팰린드롬에 해당하는 숫자입니다. 팰린드롬의 개수를 세는 프로그램을 작성해보세요.

		// 98 132
		// =>5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int x = Integer.parseInt(inputs[0]);
		int y = Integer.parseInt(inputs[1]);

		int ans = 0;
		int[] arr = new int[7];

		for (int i = x; i <= y; i++) {
			int num = i;
			int len = String.valueOf(num).length();
			for (int j = len-1; j >= 0; j--) {
				arr[j] = num % 10;
				num /= 10;
			}
			boolean isSame = true;
			for (int j = 0; j < len; j++) {
				if (arr[j] != arr[len - j - 1]) { // 99 => len 2 => 0, 1, 100 => len 3, 0, 2
					isSame = false;
					break;
				}
			}

			if(isSame) ans++;
		}

		System.out.println(ans);
    }
}