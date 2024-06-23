import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] memo = new int[n];

		Arrays.fill(memo, 1);

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(inputs[0]);
			arr[i][1] = Integer.parseInt(inputs[1]);
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < i; j++) {
				int x1I = arr[i][0];
				int x2J = arr[j][1];

				if(x2J < x1I){
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}

		int ans = 0;
		for(int i = 0; i < n; i++)
			ans = Math.max(ans, memo[i]);

		System.out.print(ans);
    }
}