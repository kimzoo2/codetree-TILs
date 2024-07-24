import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static List<Integer> list = new ArrayList<>();

	private static void printList(){
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	private static void choose(int cnt, boolean[] visited) {
		if(n == cnt){
			printList();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(cnt, i);
				choose(cnt + 1, visited);
				visited[i] = false;
				list.remove(cnt);
			}
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		choose(0, new boolean[n+1]);
    }
}