import java.io.*;
import java.util.*;
public class Main {
    // 다음의 연산을 N명의 사람들이 모두 제거될때까지 진행합니다.
	// 1번부터 순서대로 K번째 사람을 제거합니다.
	// 한 사람이 제거되면 남은 사람들로 원을 이루며 1번 연산을 과정을 반복합니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] order = br.readLine().split(" ");
		int n = Integer.parseInt(order[0]);
		int k = Integer.parseInt(order[1]);
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int cnt = k;
		while(!queue.isEmpty()){
			int num = queue.poll();
			if(--cnt > 0) {
				queue.add(num);
			}else {
				cnt = k;
				System.out.print(num + " ");
			}
		}
    }
}