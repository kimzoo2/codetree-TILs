import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int[] arr = new int[n];
		String[] tokenType = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tokenType[i]);
		}

		int[] memo = new int[m + 1];

		// 초기화
		for (int i = 1; i <= m; i++) {
			memo[i] = 10_000;
		}
		for (int i = 0; i < n; i++) { // 동전 타입
			for (int j = arr[i]; j <= m; j++) { // 동전 금액
				
				if (j - arr[i] >= 0) {
					memo[j] = Math.min(memo[j], memo[j - arr[i]] + 1);
				}
			}
		}

		System.out.println(memo[m]);
    }
}