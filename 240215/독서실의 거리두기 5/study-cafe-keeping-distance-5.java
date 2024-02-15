import static java.lang.Math.*;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		String seatingChart = br.readLine();
		char[] charArr = seatingChart.toCharArray();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < cnt; i++) {
			if(charArr[i] == '0'){
				charArr[i] = '1';
				int distance = getDistance(charArr, cnt);
				max = Math.max(max, distance);
				charArr[i] = '0';
			}
		}

		System.out.println(max);
	}

    private static int getDistance(char[] seatArr, int len) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if(seatArr[i] > '0' && seatArr[j] > '0') min = Math.min(min, Math.abs(i-j));
			}
		}
		return min;
	}
}