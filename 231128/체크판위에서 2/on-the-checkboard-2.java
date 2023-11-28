import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = input[j].charAt(0);
            }
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int k = i+1; k < n-1; k++) {
                    for (int l = j+1; l < m-1; l++) {
                            if(grid[0][0] != grid[i][j] &&
                            grid[i][j] != grid[k][l] &&
                            grid[k][l] != grid[n-1][m-1]) cnt++;
                    }
               }
           }
        }
        System.out.println(cnt);
    }
}