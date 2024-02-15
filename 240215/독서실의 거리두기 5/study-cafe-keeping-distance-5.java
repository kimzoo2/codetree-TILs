import static java.lang.Math.*;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		String seatingChart = br.readLine();

		int max = Integer.MIN_VALUE;
		// 좌석 위치
		for (int i = 0; i < cnt; i++) {
			// 이미 앉은 좌석
			if(seatingChart.charAt(i) > '0') continue;
			int minDistance = Integer.MAX_VALUE;

			// 앞으로 인접한 대상 있는지 확인한다.
			for (int j = i; j >= 0; j--) {
				if(seatingChart.charAt(j) > '0'){
					minDistance = min(minDistance, abs(i-j));
					break;
				}
			}
			for (int j = i; j < cnt; j++) {
				if(seatingChart.charAt(j) > '0'){
					minDistance = min(minDistance, abs(i-j));
					break;
				}
			}
			max = max(max, minDistance);
		}
		System.out.println(max);
	}
}