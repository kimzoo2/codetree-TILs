import static java.lang.Math.*;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		String seatingChart = br.readLine();

		int oldSeat = Integer.MAX_VALUE;

		// 기존 거리 구하기
		for (int i = 0; i < cnt; i++) {
			// 앉은 자리가 0이면
			if (seatingChart.charAt(i) == '0')
				continue;
			int minDistance = Integer.MAX_VALUE;

			// 앞으로 인접한 대상 있는지 확인한다.
			for (int j = i; j >= 0; j--) {
				if (seatingChart.charAt(j) > '0' && i!=j) {
					minDistance = min(minDistance, abs(i - j));
					break;
				}
			}
			for (int j = i; j < cnt; j++) {
				if (seatingChart.charAt(j) > '0' && i!=j) {
					minDistance = min(minDistance, abs(i - j));
					break;
				}
			}
			oldSeat = Math.min(oldSeat, minDistance);
		}
		int newSeat = Integer.MIN_VALUE;
		// 좌석 거리 구하기
		for (int i = 0; i < cnt; i++) {
			if (seatingChart.charAt(i) > '0') // 이미 앉은 자리는 앉지 않는다.
				continue;
			int minDistance = Integer.MAX_VALUE;

			// 앞으로 인접한 대상 있는지 확인한다.
			for (int j = i; j >= 0; j--) {
				if (seatingChart.charAt(j) > '0') {
					minDistance = min(minDistance, abs(i - j));
					break;
				}
			}
			for (int j = i; j < cnt; j++) {
				if (seatingChart.charAt(j) > '0') {
					minDistance = min(minDistance, abs(i - j));
					break;
				}
			}
			newSeat = Math.max(newSeat, minDistance);
		}
		
		System.out.println(Math.min(newSeat, oldSeat));
	}
}