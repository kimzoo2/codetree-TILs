import java.io.*;
import java.util.*;
public class Main {

    private static int n,m,ans;
	private static int[] ansArr;

	private static ArrayList<int[]> queryList = new ArrayList<>();
	private static int[] ghostLeg(ArrayList<int[]> querys) {
		Collections.sort(querys, (o1, o2) -> o1[1] - o2[1]);
		int[] ans = new int[n + 1];
		// 초기 순서대로 ans를 세팅한다.
		for (int i = 1; i <= n; i++) {
			ans[i] = i;
		}
		if(querys.isEmpty()) return ans;

		for (int i = 0; i < querys.size(); i++) {
			int idx = querys.get(i)[0];
			int temp = ans[idx];

			ans[idx] = ans[idx + 1];
			ans[idx + 1] = temp;
		}
		return ans;
	}

	private static boolean equals(int[] newArr){
		for (int i = 1; i <= n; i++) {
			if(newArr[i] != ansArr[i]) return false;
		}
		return true;
	}

	private static void drawLine(ArrayList<int[]> selectedLines, int cnt){
		if(cnt == m){
			if(equals(ghostLeg(selectedLines)))
				ans = Math.min(cnt, selectedLines.size());
			return;
		}

		// 선을 긋는다.
		selectedLines.add(queryList.get(cnt));
		drawLine(selectedLines, cnt + 1);

		// 선을 긋지 않는다.
		selectedLines.remove(selectedLines.size()-1);
		drawLine(selectedLines, cnt + 1);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		ans = m;

		for (int i = 0; i < m; i++) {
			String[] ab = br.readLine().split(" ");
			int[] query = {Integer.parseInt(ab[0]), Integer.parseInt(ab[1])};
			queryList.add(query);
		}
		ansArr = ghostLeg(queryList);
		ArrayList<int[]> selectedLines = new ArrayList<>();

		drawLine(selectedLines, 0);

		System.out.println(ans);
	}
}