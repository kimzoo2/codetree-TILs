import java.io.*;

public class Main {
    private static int n;

	private static void printList(int[] arr){
		for (int i = 0; i <n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	private static void choose(int cnt, boolean[] visited, int[] ansArr) {
		if(n == cnt){
			printList(ansArr);
			return;
		}
		for (int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ansArr[cnt] = i;
				choose(cnt + 1, visited, ansArr);
				visited[i] = false;
			}
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] ansArr = new int[n];
		choose(0, new boolean[n + 1], ansArr);
    }
}