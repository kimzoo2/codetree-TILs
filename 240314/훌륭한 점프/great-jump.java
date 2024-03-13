import java.io.*;
public class Main {
    public static int[] arr = new int[101];
    public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		int n = Integer.parseInt(size[0]);
		int dist = Integer.parseInt(size[1]);

		String[] tokens = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tokens[i]);
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if(isPossible(i, n, dist)){
				ans = Math.min(i, ans);
			}
		}
		System.out.println(ans);
	}

	private static boolean isPossible(int maxValue, int n, int dist) {
		int[] tempArr = new int[n];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] <= maxValue) {
				tempArr[idx++] = i;
			}
		}

		if(idx <= 1) return false;

		for (int i = 1; i < idx; i++) {
			if (tempArr[i] - tempArr[i - 1] > dist) {
				return false;
			}
		}

		return true;
	}
}