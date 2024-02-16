import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		// 5 3
		// 1
		// 6
		// 4
		// 3
		// 1
		// => 4 (1, 1, 3, 4)
		int n = Integer.parseInt(size[0]);
		int k = Integer.parseInt(size[1]);
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int min = arr[0];
		int max = arr[n-1];

		int ans = Integer.MIN_VALUE;
		for (int i = min; i < max; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if(i<=arr[j] && arr[j]<=i+k) cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}