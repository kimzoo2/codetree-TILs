import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int aLen = a.length();
		int bLen = b.length();

		int[][] dp = new int[aLen + 1][bLen + 1];

		// initialize
		for (int i = 1; i <= aLen; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= bLen ; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= aLen; i++) {
			for (int j = 1; j <= bLen; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j]) + 1;
				}
			}
		}

		System.out.println(dp[aLen][bLen]);
    }
}