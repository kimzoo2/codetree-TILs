import java.io.*;
public class Main {
    static int n = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]) + 1;
        int queryCnt = Integer.parseInt(input[1]);
        int[][] grid = new int[n][n];

        // 칠한 즉시 편안한 상태인지 확인하라
        // 편안한 상태 = 위아래 양옆으로 인접한 4개의 칸 중, 색칠되어 있는 칸이 3개인 경우
        for (int i = 0; i < queryCnt; i++) {
            String[] targets = br.readLine().split(" ");
            int x = Integer.parseInt(targets[0]);
            int y = Integer.parseInt(targets[1]);
            grid[x][y] = 1;
            if(isCozyStatus(x, y, grid)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean isCozyStatus(int x, int y, int[][] grid){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && grid[nx][ny] == 1){
                cnt++;
            }
        }

        return cnt == 3;
    }

    private static boolean inRange(int x, int y){
        return (x >= 1 && y >= 1 && x < n && y < n);
    }
}