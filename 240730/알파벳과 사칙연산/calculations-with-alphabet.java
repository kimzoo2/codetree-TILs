import java.io.*;
import java.util.*;
public class Main {

	private static int n;
	private static int ans;

	private static int calculate(char[] chars){
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

	private static void choose(int cnt, int num, char[] chars) {
		// 마지막에 도달하면 return 한다.
		if(cnt > chars.length - 1){
			ans = Math.max(ans, calculate(chars));
			// 가장 큰 값이면 ans에 넣는다.
			return;
		}

		chars[cnt] = (char)(num + '0');
		for (int i = 1; i <= 4; i++) {
			choose(cnt + 2, i, chars);
		}
	}
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] charArray = str.toCharArray();
		// 알파벳과 기호를 분해한다
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(charArray[i])) {
				charArray[i] = 1 + '0';
			}
		}
		// 알파벳을 숫자로 변환하고 계산한다.
		for (int i = 1; i <= 4; i++) {
			choose(0, i, charArray);
		}

		// max 값을 출력한다.
		System.out.println(ans);

	}
}