import java.io.*;
public class Main {
    static int N = 0;
    static int M = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int x = 0;
        int y = 0;

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int[][] grid = new int[N][M];
        grid[x][y] = 1;
        int dirNum = 0;

        for (int i = 2; i <= N * M; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(!inRange(nx, ny) || grid[nx][ny] != 0){
                dirNum = (dirNum + 1) % 4;
            }

            x += dx[dirNum];
            y += dy[dirNum];
            grid[x][y] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean inRange(int x, int y){
        return (x >= 0 && y >= 0 && x < N && y < M);
    }
}