import java.io.*;
public class Main {

    static int N,m;

    private static void print(int[] arr) {
		for (int i = 0; i < m; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

    private static boolean isDuplicated(int num, int[] arr){
		for (int i = 0; i < m; i++) {
			if(num == arr[i]) return true;
		}
		return false;
	}

	private static void bfs3(int cnt, int[] arr){
		if(cnt == m){
			print(arr);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(!isDuplicated(i, arr)) {
				if(cnt > 0){
					if(arr[cnt - 1] < i){
						arr[cnt] = i;
						bfs3(cnt + 1, arr);
					}
				}else{
					arr[cnt] = i;
					bfs3(cnt + 1, arr);
				}
			}
			arr[cnt] = 0;
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		int[] arr = new int[m];
		bfs3(0, arr);
	}
}