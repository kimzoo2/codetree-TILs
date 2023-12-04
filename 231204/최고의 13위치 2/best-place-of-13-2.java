import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(split[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-2; j++) {
                int cnt = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n-2; l++) {
                        if(i == k && l <= j+2) continue;
                        int cnt2 = grid[k][l] + grid[k][l+1] + grid[k][l+2];
                        max = Math.max(max, (cnt + cnt2));
                    }
                }
            }
        }
        System.out.println(max);
    }
}