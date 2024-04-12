import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] train = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			train[i][0] = Integer.parseInt(split[0]); //위치
			train[i][1] = Integer.parseInt(split[1]); //속도
		}

		int firstLocation = train[n-1][0];

		for (int i = 0; i < firstLocation; i++) {
			for (int j = 0; j <n ; j++) {
				train[j][0] += train[j][1];
			}
		}
		int cnt = 1;
		int num = train[n-1][0];
		for (int i = n-2; i >= 0; i--) {
			if(num > train[i][0]){
				cnt++;
				num = train[i][0];
			}
		}
		System.out.println(cnt);
	}
}