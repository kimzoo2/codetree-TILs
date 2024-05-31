import java.util.ArrayList;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
	public static final int MAX_DIGIT = 10;
	public static final int MAX_K = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");

		ArrayList[] arrayLists = new ArrayList[MAX_DIGIT];

		for (int i = MAX_K -1; i >= 0; i--) {
			for (int j = 0; j < MAX_DIGIT; j++) {
				arrayLists[j] = new ArrayList<String>();
			}
			for (String number : split) {
				int digit = 0;
				if(number.length() > i) digit = number.charAt(i)- '0';
				// 자릿수 위치 버킷에 데이터 저장
				arrayLists[digit].add(number);
			}
			int idx = 0;
			for (int j = 0; j < MAX_DIGIT; j++) {
				// 기존 배열에 자릿수 별로 정렬
				for (int k = 0; k < arrayLists[j].size(); k++) {
					split[idx++] = (String)arrayLists[j].get(k);
				}
			}
		}

		for (String string : split) {
			System.out.print(string + " ");
		}
	}
}