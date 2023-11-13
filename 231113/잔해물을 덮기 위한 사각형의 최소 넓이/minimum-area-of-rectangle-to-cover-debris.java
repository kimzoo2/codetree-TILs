import java.io.*;
public class Main {
    static int OFFSET = 100;
    static int MAXLEN = OFFSET * 2;
    static int[][] grid4 = new int[MAXLEN+1][MAXLEN+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            int x1, y1, x2, y2;
            String[] split = br.readLine().split(" ");
            x1 = Integer.parseInt(split[0]) + OFFSET;
            y1 = Integer.parseInt(split[1]) + OFFSET;
            x2 = Integer.parseInt(split[2]) + OFFSET;
            y2 = Integer.parseInt(split[3]) + OFFSET;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if(i == 0) grid4[j][k]++;
                    else grid4[j][k]--;
                }
            }
        }

        // 현재 grid 기준으로 x1, x2, y1, y2 구하기
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < MAXLEN; i++) {
            for (int j = 0; j < MAXLEN; j++) {
                if(grid4[x1][y1] < grid4[i][j]){
                    x1 = i;
                    y1 = j;
                }

                if(grid4[x2][y2] <= grid4[i][j]){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        System.out.println((x2+1 - x1) * (y2+1 - y1));
    }
}