import java.io.*;
public class Main {
    static int OFFSET_1 = 100;
    static int MAX_1 = OFFSET_1 * 2;
    static int[][] grid_1 = new int[MAX_1+1][MAX_1+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2;
        for (int i = 0; i < cnt; i++) {
            // 짝수는 빨간색 사각형, 홀수는 파란색 사각형
            String[] split = br.readLine().split(" ");
            x1 = Integer.parseInt(split[0]) + OFFSET_1;
            y1 = Integer.parseInt(split[1]) + OFFSET_1;
            x2 = Integer.parseInt(split[2]) + OFFSET_1;
            y2 = Integer.parseInt(split[3]) + OFFSET_1;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k <y2; k++) {
                    if(i % 2 == 0){
                        grid_1[j][k] = 1;
                    }else{
                        grid_1[j][k] = 2;
                    }
                }
            }
        }
        int area = 0;
        for (int i = 0; i <= MAX_1; i++) {
            for (int j = 0; j < MAX_1; j++) {
                if(grid_1[i][j] == 2) area++;
            }
        }
        System.out.println(area);
    }
}