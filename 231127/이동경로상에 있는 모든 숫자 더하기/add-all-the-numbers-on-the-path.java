import java.io.*;
public class Main {
    static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        String input = br.readLine();
        int[][] grid = new int[n][n];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dirNum = 3; // 북쪽에서 시작한다.
        int x, y;
        x = y = n/2; // 가운데서 시작한다.

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = grid[x][y];

        for (int i = 0; i < m; i++) {
            char direction = input.charAt(i);
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];
            if(direction == 'R') dirNum = (dirNum + 1) % 4;
            else if(direction == 'L') dirNum = (dirNum + 3) % 4;
            else if(direction == 'F' && inRange(nx, ny)){
                x = nx;
                y = ny;
                ans += grid[x][y];
            }
        }
        System.out.println(ans);
    }
    private static boolean inRange(int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < n);
    }
}