import java.io.*;

public class Main {

    private static int n,k;

	private static boolean isDuplicated(int cnt, int[] arr){
        if(cnt < 2) return false;
		for (int i = cnt; i >= 0 && i > cnt - 3; i--) {
			if(arr[i] != arr[cnt]) return false;
		}
		return true;
	}
	private static void bfs(int cnt, int[] arr) {
		if(k == cnt){
			if(isDuplicated(cnt-1, arr)) return;
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if(isDuplicated(cnt, arr)) continue;
			arr[cnt] = i;
			bfs(cnt+1, arr);
			arr[cnt] = 0;
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]); // 숫자
		k = Integer.parseInt(inputs[1]); // 자릿수
		int[] arr = new int[k];
		for (int i = 1; i <= n; i++) {
			arr[0] = i;
			bfs(1, arr);
		}
	}
}