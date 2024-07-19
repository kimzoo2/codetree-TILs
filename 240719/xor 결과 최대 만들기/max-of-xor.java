import java.io.*;
public class Main {
    private static int n,m,max;
	private static int[] combinationArr = new int[20];

	private static void choose(int[] nums, int cnt, int lastNum) {
		// cnt가 m일 때 재귀함수를 종료한다.
			// combinationArr에 들어있는 값들의 xor 값과 max 중 큰 값을 넣는다.
		if(cnt == m){
			int ans = 0;
			for (int i = 0; i < m; i++) {
				ans ^= combinationArr[i];
			}
			max = Math.max(max, ans);
			return;
		}

		// 반복문을 돌아가며 combinationArr에 xor할 값을 넣는다.
		for (int i = cnt; i < n; i++) {
			if(lastNum < nums[i]) {
				combinationArr[cnt] = nums[i];
				choose(nums, cnt + 1, i);
			}
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);

		String[] split = br.readLine().split(" ");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(split[i]);
		}

		choose(nums, 0, 0);
		System.out.println(max);
	}
}