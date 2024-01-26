import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		// 19 21
		int max = 0;
		for (int i = x; i <= y; i++) {
			int num = i;
			int ans = 0;
			while(num > 0){
				ans += num %10;
				num /= 10;
			}
			max = Math.max(max, ans);
		}
		System.out.println(max);
    }
}