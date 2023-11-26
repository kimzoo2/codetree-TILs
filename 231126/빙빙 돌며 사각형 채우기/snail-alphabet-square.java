import java.io.*;
public class Main {
    static int n = 0;
    static int m = 0;
    static int limitedNumber = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dirNum = 0;

        char[][] grid = new char[n][m];
        int x = 0;
        int y = 0;
        int magicNum = 65;
        grid[x][y] = (char)magicNum;

        for (int i = 1; i < n*m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(!inRange2(nx, ny) || grid[nx][ny] != '\u0000'){
                dirNum = (dirNum + 1) % 4;
            }
            x += dx[dirNum];
            y += dy[dirNum];
            grid[x][y] = (char)((i % limitedNumber) + magicNum);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inRange2(int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
}