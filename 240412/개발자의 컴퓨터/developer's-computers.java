import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[1000 + 1];

		for (int i = 0; i <n; i++) {
			String[] split = br.readLine().split(" ");
			int startTime = Integer.parseInt(split[0]);
			int endTime = Integer.parseInt(split[1]);
			int computerCnt = Integer.parseInt(split[2]);
			for (int j = startTime; j < endTime; j++) {
				time[j] += computerCnt;
			}
		}

		int maxCount = 0;
		for (int i = 0; i < time.length; i++) {
			maxCount = Math.max(maxCount, time[i]);
		}

		System.out.println(maxCount);
    }
}