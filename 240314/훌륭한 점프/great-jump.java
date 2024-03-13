import java.io.*;
public class Main {
    public static final int MAX_N = 100;
	public static final int MAX_NUM = 100;

	public static int n, k;
	public static int[] arr = new int[MAX_N];

    public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		k = Integer.parseInt(size[1]);

		String[] tokens = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tokens[i]);
		}

		for (int i = Math.max(arr[0], arr[n - 1]); i <= MAX_NUM; i++) {
			if(isPossible(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean isPossible(int limit) {
		int lastIdx = 0;
		for(int i = 1; i < n; i++) {
			if(arr[i] <= limit) {
				if(i - lastIdx > k)
					return false;
				lastIdx = i;
			}
		}

		return true;
	}
}