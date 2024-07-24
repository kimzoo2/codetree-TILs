import java.io.*;
import java.util.*;
public class Main {

    private static int n;
	private static int ans;

    private static void chooseLine(int[][] lines, int idx, int cnt){
        ans = Math.max(ans, cnt);
		if(n == idx + 1){
			return;
		}

		for (int i = 0; i < n; i++) {
			if(idx >= 0 && lines[idx][1] >= lines[i][0]) continue;
			chooseLine(lines, i, cnt + 1);
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] lines = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			lines[i][0] = Integer.parseInt(split[0]);
			lines[i][1] = Integer.parseInt(split[1]);
		}
		Arrays.sort(lines, Comparator.comparingInt(o -> o[1]));
		chooseLine(lines, -1, 0);
		System.out.println(ans);
	}
}