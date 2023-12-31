import java.io.*;
public class Main {
    static int OFF_SET = 100;
    static int MAX_N = OFF_SET * 2 + 1;
    static int[][] grid = new int[MAX_N][MAX_N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2 = 0;
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            String[] split = str.split(" ");
            x1 = Integer.parseInt(split[0]) + OFF_SET;
            y1 = Integer.parseInt(split[1]) + OFF_SET;
            x2 = Integer.parseInt(split[2]) + OFF_SET;
            y2 = Integer.parseInt(split[3]) + OFF_SET;
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k <y2; k++) {
                    grid[j][k]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                if(grid[i][j] > 0) result++;
            }
        }

        System.out.println(result);
    }
}