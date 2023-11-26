import java.io.*;
public class Main {
    static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        int x, y;
        x = y = n/2;
        grid[x][y] = 1;
        int[] dx = {0, -1, 0, 1}; // 동, 북, 서, 남
        int[] dy = {1, 0, -1, 0};
        int dirNum = 0;

        for (int i = 2; i <= n*n; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(!canGo(nx, ny)){
                dirNum = (dirNum + 1) % 4;
            }

            x += dx[dirNum];
            y += dy[dirNum];
            grid[x][y] = i;

            int nextDirNum = (dirNum + 1) % 4;
            int nextX = nx + dx[nextDirNum];
            int nextY = ny + dy[nextDirNum];

            if(grid[nextX][nextY] == 0){
                dirNum = nextDirNum;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static boolean canGo(int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < n);
    }
}