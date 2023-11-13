import java.io.*;

public class Main {
    static int OFFSET3 = 100;
    static int MAX_LEN = OFFSET3 * 2 + 1;
    static int[][] grid3 = new int[MAX_LEN][MAX_LEN];
    static int AREA = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2;
        for (int i = 0; i < cnt; i++) {
            String[] split = br.readLine().split(" ");
            x1 = Integer.parseInt(split[0]) + OFFSET3;
            y1 = Integer.parseInt(split[1]) + OFFSET3;
            x2 = x1 + AREA;
            y2 = y1 + AREA;
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    grid3[j][k]++;
                }
            }
        }
        int area = 0;
        for (int i = 0; i < MAX_LEN; i++) {
            for (int j = 0; j < MAX_LEN; j++) {
                if(grid3[i][j] > 0) area++;
            }
        }
        System.out.println(area);
    }
}