import java.io.*;
import java.util.*;
public class Main {

	private static int n;
	private static int ans = Integer.MIN_VALUE;
	private static String str;

	private static int calculate(int[] alphabetLocations){
		// String 연산을 실제로 연산한다.
		char[] chars = str.toCharArray();

		char ch = chars[0];
		for (int i = 0; i < alphabetLocations.length; i++) {
			// 같은 알파벳이면 같은 숫자로 치환한다.
			for (int j = 0; j < chars.length ; j++) {
				if(Character.isAlphabetic(chars[j]) && ch == chars[j]){
					chars[j] = (char)(alphabetLocations[i] + '0');
				}
			}

			// 치환할 다음 알파벳을 찾는다.
			for (int j = 0; j < chars.length ; j++) {
				if(Character.isAlphabetic(chars[j])){
					ch = chars[j];
					break;
				}
			}
		}
		// String 연산을 실제로 연산한다.
		int ans = chars[0] - '0';

		for (int i = 1; i < chars.length - 1; i += 2) {
			int num = chars[i + 1] - '0';
			switch (chars[i]) {
				case '+':
					ans += num; break;
				case '-':
					ans -= num; break;
				case '*':
					ans *= num; break;
				default: ans %= num; break;
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
		char[] charArray = str.toCharArray();
		// 알파벳과 기호를 분해한다
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(charArray[i])) {
				set.add(charArray[i]);
			}
		}
		int[] alphabetLocationArr = new int[set.size()];
		// 알파벳을 숫자로 변환하고 계산한다.
		for (int i = 1; i <= 4; i++) {
			choose(0, i, alphabetLocationArr);
		}

		// max 값을 출력한다.
		System.out.println(ans);

	}
}