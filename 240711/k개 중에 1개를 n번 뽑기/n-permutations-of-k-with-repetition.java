import java.io.*;

public class Main {
    static int K = 0;
	static int N = 0;
	private static void recursive(int number, int[] arr, int len) {
		if(len > N){
			return;
		}

		if(len == N){
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= K; i++) {
 			if(arr[len] == 0){
				arr[len] = i;
				recursive(i, arr, len + 1);
				arr[len] = 0;
			}
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 2 2
		// 1 1
		// 1 2
		// 2 1
		// 2 2
		String[] inputs = br.readLine().split(" ");
		K = Integer.parseInt(inputs[0]);
		N = Integer.parseInt(inputs[1]);
		int[] arr = new int[N];
		for (int i = 1; i <= K; i++) {
			arr[0] = i;
			recursive(i, arr, 1);
			arr[0] = 0;
		}
	}
}