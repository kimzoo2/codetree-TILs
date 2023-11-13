import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2 = 0;
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            String[] split = str.split(" ");
            x1 = Integer.parseInt(split[0]);
            y1 = Integer.parseInt(split[1]);
            x2 = Integer.parseInt(split[2]);
            y2 = Integer.parseInt(split[3]);
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