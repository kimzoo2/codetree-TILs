import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] memo = new int[n];
		int[] line = new int[1000 + 1];

		Arrays.fill(memo, 1);

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(inputs[0]);
			arr[i][1] = Integer.parseInt(inputs[1]);
		}

		for (int i = 0; i < n; i++) {
			int max = 1;
			fillLine(arr[i][0], arr[i][1], line);
			for (int j = 0; j < n; j++) {
				if(i == j) continue;
				if(fillLine(arr[j][0], arr[j][1], line)){
					max++;
				}
			}
			memo[i] = Math.max(memo[i], max);
			// 선분 배열 초기화
			Arrays.fill(line, 0);
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, memo[i]);
		}

		System.out.println(max);
    }

    private static boolean fillLine(int x, int y, int[] line){
		// 겹친 선분이 있으면 채우지 않는다.
		for (int i = x-1; i <= y-1; i++) {
			if(line[i] == 1) return false;
		}

		for (int i = x-1; i <= y-1; i++) {
			line[i] = 1;
		}
		return true;
	}
}