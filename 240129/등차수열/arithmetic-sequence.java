import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		String[] split = br.readLine().split(" ");

		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		// 등차수열을 이루는 횟수 최댓값 구하기
		// a, k, b 형태로 구해야 함
		// 4
		// 7 6 4 3
		// => 2

		// 3 4 6 7
		Arrays.sort(arr);
		int a = arr[0]; // 3
		int b = arr[cnt-1]; // 7

		int max = Integer.MIN_VALUE;
		for (int i = a; i <= b; i++) { // 5
			int apCnt = 0;
			for (int j = 0; j < cnt; j++) { // 3
				for (int k = j+1; k < cnt; k++) { // 4
					if(i - arr[j] == arr[k] - i) apCnt++;
				}
			}
			max = Math.max(max, apCnt);
		}

		System.out.println(max);
	}
}