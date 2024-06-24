import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws IOException {
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

		Arrays.fill(memo, 10_001);


		for (int i = 0; i < n; i++) {
			for (int j = m; j >= 1; j--) {
				// memo[j] != 0
				if(j - arr[i] >= 0 && memo[j - arr[i]] != 10_001){
					memo[j] = Math.min(memo[j], memo[j - arr[i]] + 1);
				}

				if(memo[j] == 10_001 && arr[i] == j){
					memo[j] = 1;
				}
			}
		}

		System.out.println(memo[m] == 10_001 ? -1 : memo[m]);
    }
}