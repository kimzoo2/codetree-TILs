import java.io.*;
public class Main {
    static int OFFSET2 = 1000;
    static int MAX_N2 = OFFSET2*2+1;
    static int[][] grid2 = new int[MAX_N2][MAX_N2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1, x2, y1, y2 = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            String[] split = str.split(" ");
            x1 = Integer.parseInt(split[0]) + OFFSET2;
            y1 = Integer.parseInt(split[1]) + OFFSET2;
            x2 = Integer.parseInt(split[2]) + OFFSET2;
            y2 = Integer.parseInt(split[3]) + OFFSET2;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if(i <= 1){
                        grid2[j][k]++;
                    }else{
                        grid2[j][k]--;
                    }
                }
            }
        }
        int area = 0;
        for (int i = 0; i < MAX_N2; i++) {
            for (int j = 0; j < MAX_N2; j++) {
                if(grid2[i][j] > 0) area++;
            }
        }
        System.out.println(area);
    }
}