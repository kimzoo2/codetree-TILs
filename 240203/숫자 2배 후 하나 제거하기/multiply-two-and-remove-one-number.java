import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

		//n개의 숫자가 주어졌을 때, 하나의 숫자를 선택해 2배를 한 후,
		//다시 하나의 숫자를 선택해 제거하여 남은 n - 1개의 원소 중 인접한 숫자간의 차의 합이 최소가 되도록 하는 프로그램을 작성해보세요.

		// 5
		// 1 9 8 2 7
		// => 8

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] split = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		int min = Integer.MAX_VALUE;
		// 숫자를 선택해 2배를 곱한다.
		for (int i = 0; i < n; i++) {
			arr[i] *= 2;
			int[] temp = new int[n-1];
			// 숫자를 선택해 제거한다.
			for (int j = 0; j < n; j++) {
				if(i == j) continue;

				// 남은 값을 temp에 넣는다.
				int cnt = 0;
				for (int k = 0; k < n; k++) {
					if(j != k) temp[cnt++] = arr[k];
				}

				int sum = 0;
				// 인접한 숫자간의 차를 구한다.
				for (int k = 1; k < n-1; k++) {
					sum += Math.abs(temp[k-1] - temp[k]);
				}
				min = Math.min(min, sum);
			}

			arr[i] /= 2;
		}

		System.out.println(min);

	}
}