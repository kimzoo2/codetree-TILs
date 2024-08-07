import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] memo = new int[n];

		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}

		for (int i = 1; i < n; i++) {
			memo[i] = Integer.MIN_VALUE;
		}
		memo[0] = arr[0];
		for (int i = 1; i < n; i++) {
			memo[i] = Math.max(arr[i], memo[i - 1] + arr[i]);
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, memo[i]);
		}

		System.out.println(max);
	}
}