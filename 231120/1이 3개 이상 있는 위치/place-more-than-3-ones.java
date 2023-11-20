import java.io.*;

public class Main {
    static int INPUT_N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        INPUT_N = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] grid = new int[INPUT_N][INPUT_N];

        for (int i = 0; i < INPUT_N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < INPUT_N; j++) {
                grid[i][j] = Integer.parseInt(split[j]);
            }
        }
        int cnt = 3;
        int result = 0;

        for (int i = 0; i < INPUT_N; i++) {
            for (int j = 0; j < INPUT_N; j++) {
                int n = 0;
                for (int dirNum = 0; dirNum < 4; dirNum++) {
                    int nx = i + dx[dirNum];
                    int ny = j + dy[dirNum];
                    if(inRange(nx, ny) && grid[nx][ny] == 1) n++;
                }
                if(n >= cnt) result++;
            }
        }

        System.out.println(result);
    }

    private static boolean inRange(int x, int y){
        if(x >= 0 && y >= 0 && x < INPUT_N && y < INPUT_N){
            return true;
        }
        return false;
    }
}