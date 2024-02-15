import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split1 = br.readLine().split(" ");
		int cnt = Integer.parseInt(split1[0]);
		int move = Integer.parseInt(split1[1]);
		int[] arr = new int[cnt];
		String[] split = br.readLine().split(" ");
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		int max = 0;
		for (int i = 0; i <cnt; i++) { // 시작위치
			int sum = 0;
			int idx = arr[i]; // 위치 값을 구한다.
			for (int j = 0; j < move; j++) {
				// if(idx == arr[idx-1]) break; // 위치값이 인덱스와 동일하면 해당 시작 위치는 멈춘다.
				sum += idx; // 위치 값을 더한다.
				idx = arr[idx -1]; // 위치값을 인덱스로 전환한다.
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}