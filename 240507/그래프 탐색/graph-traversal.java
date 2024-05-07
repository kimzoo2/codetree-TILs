import java.io.*;
public class Main {
    static int CNT = 0;
	static int[][] GRAPH = new int[1001][1001];
	static boolean[] checked = new boolean[1001];
    private static void searchGraph(int vertex){
		for (int i = 1; i < GRAPH[vertex].length; i++) {
			if(GRAPH[vertex][i] == 1 && !checked[i]){
				checked[i] = true;
                CNT++;
				searchGraph(i);
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		for (int i = 0; i < m; i++) {
			String[] pair = br.readLine().split(" ");
			int start =Integer.parseInt(pair[0]);
			int end =Integer.parseInt(pair[1]);
			GRAPH[start][end] = 1;
			GRAPH[end][start] = 1;
		}
        checked[1] = true;
		searchGraph(1);

		System.out.println(CNT);
    }
}