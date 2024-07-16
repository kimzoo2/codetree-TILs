import java.io.*;
public class Main {

	public static int n;
	public static int ans;

	public static boolean isBeautiful(int[] arr) {
		// 연달아 같은 숫자가 나오는 시작 위치를 잡습니다.
		int len = arr.length;
		int num = arr[0];
		for (int i = 0; i < len; i += num) {
			num = arr[i];

			if(i + num > len) return false;
			for (int j = i; j < i + num; j++) {
				if(num != arr[j]){
					return false;
				}
			}
		}

		return true;
	}

	public static void countBeautifulSeq(int cnt, int[] arr) {
		if(cnt == n) {
			if(isBeautiful(arr))
				ans++;
			return;
		}

		for(int i = 1; i <= 4; i++) {
			arr[cnt] = i;
			countBeautifulSeq(cnt + 1, arr);
			arr[cnt] = 0;
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		countBeautifulSeq(0, arr);

		System.out.print(ans);
    }
}