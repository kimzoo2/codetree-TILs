import java.io.*;
import java.util.ArrayList;
public class Main {
    static int CNT = 0;
	static boolean[] checked = new boolean[1001];
    static ArrayList<Integer>[] list = new ArrayList[1000 + 1];
	private static void searchGraph_ArrayList(int vertex){
		for (int i = 0; i < list[vertex].size(); i++) {
			int currX = list[vertex].get(i);
			if(!checked[currX]){
				CNT++;
				checked[currX] = true;
				searchGraph_ArrayList(currX);
			}
		}
	}
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			String[] pair = br.readLine().split(" ");
			int start =Integer.parseInt(pair[0]);
			int end =Integer.parseInt(pair[1]);
			list[start].add(end);
			list[end].add(start);
		}
		checked[1] = true;
		searchGraph_ArrayList(1);
		System.out.println(CNT);
    }
}