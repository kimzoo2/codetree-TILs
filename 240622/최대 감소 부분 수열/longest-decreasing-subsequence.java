import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		int[] memo = new int[n];

		memo[0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = n-1; j >= 0; j--) {
				if(arr[i] < arr[j]){
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}

		int max = 1;

		for (int i = 1; i < n; i++) {
			max = Math.max(memo[i], max);
		}

		System.out.println(max);

	}
}