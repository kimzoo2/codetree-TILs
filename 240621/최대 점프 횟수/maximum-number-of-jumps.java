import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		int[] memo = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n && j <= i + arr[i]; j++) {
				memo[j] = Math.max(memo[j] + 1, memo[i] + 1);
			}
		}

		int max = 0;

		for (int i = 1; i < n; i++) {
			if(memo[i] == 0){
				max = 0;
				break;
			}
			max = Math.max(memo[i], max);
		}

		System.out.println(max);
    }
}