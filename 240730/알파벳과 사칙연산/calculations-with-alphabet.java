import java.io.*;
import java.util.*;
public class Main {

	private static int n;
	private static int ans = Integer.MIN_VALUE;
	private static String str;

	private static int convert(int[] alphabetLocations, char ch){
		return alphabetLocations[ch - 'a'];
	}

	private static int calculate(int[] alphabetLocations){
		// String 연산을 실제로 연산한다.
		char[] chars = str.toCharArray();
		int ans = convert(alphabetLocations, chars[0]);
		for (int i = 1; i < chars.length - 1; i += 2) {
			int num = convert(alphabetLocations, chars[i + 1]);
			switch (chars[i]) {
				case '+':
					ans += num; break;
				case '-':
					ans -= num; break;
				case '*':
					ans *= num; break;
			}
		}

		return ans;
	}

	private static void choose(int cnt, int num, int[] alphabetLocations) {
		// 마지막에 도달하면 return 한다.
		if(cnt == alphabetLocations.length){
			ans = Math.max(ans, calculate(alphabetLocations));
			// 가장 큰 값이면 ans에 넣는다.
			return;
		}

		alphabetLocations[cnt] = num;
		for (int i = 1; i <= 4; i++) {
			choose(cnt + 1, i, alphabetLocations);
		}
	}
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		int[] alphabetLocationArr = new int[6];
		// 알파벳을 숫자로 변환하고 계산한다.
		for (int i = 1; i <= 4; i++) {
			choose(0, i, alphabetLocationArr);
		}

		// max 값을 출력한다.
		System.out.println(ans);
	}
}