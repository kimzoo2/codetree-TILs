import java.io.*;
import java.util.*;
public class Main {

    private static int n;
	private static int ans;
	private static ArrayList<int[]> selectedSegs = new ArrayList<>();

    private static void chooseLine(int[][] lines, int cnt){
		if(n == cnt){
			if(possible())
				ans = Math.max(ans, selectedSegs.size());
			return;
		}

		selectedSegs.add(lines[cnt]);
		chooseLine(lines, cnt + 1);
		selectedSegs.remove(selectedSegs.size() - 1);
		chooseLine(lines, cnt + 1);

	}

	private static boolean possible() {
		for (int i = 0; i < selectedSegs.size(); i++) {
			for (int j = i+1; j < selectedSegs.size(); j++) {
				if(selectedSegs.get(i)[1] >= selectedSegs.get(j)[0]) return false;
			}
		}
		return true;
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
		chooseLine(lines, 0);
		System.out.println(ans);
	}
}