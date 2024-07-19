import java.io.*;
public class Main {

    static int N,m;

    private static void print(int[] arr) {
		for (int i = 0; i < m; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void choose(int cnt, int curNum, int[] arr){
		if (cnt == m || curNum == N + 1) {
			if (cnt == m)
				print(arr);

			return;
		}

		arr[cnt] = curNum;
		choose(cnt + 1, curNum + 1, arr);
		arr[cnt] = 0;

		choose(cnt, curNum + 1, arr);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		int[] arr = new int[m];
		choose(0, 1, arr);
	}
}