import java.io.*;
public class Main {
    static int n = 0;
    static int m = 0;
    static int DIR_NUM = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        // L이면 해당 방향으로 한 칸인 더한 위치가 E인지 확인한다. 이때, 한 칸 더한 위치가 범위 안에 속하는지 확인한다.
        // E면 해당 방향으로 한 칸 더한 위치가 E인지 확인한다.
        // 맞으면 카운트를 증가한다.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += countCorrectWord(grid, i, j);
            }
        }

        System.out.println(cnt);
    }

    private static int countCorrectWord(char[][] grid, int x, int y){
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        int cnt = 0;

        if(grid[x][y] == 'L'){ // 해당 글자가 L인지 확인한다.
            for (int i = 0; i < DIR_NUM; i++) {
                int curt = 1;
                int curx = x;
                int cury = y;
                while(true){
                    int nx = curx + dx[i];
                    int ny = cury + dy[i];
                    if(!inRange(nx, ny)) break;
                    if(grid[nx][ny] != 'E') break;
                    curx = nx;
                    cury = ny;
                    curt++;
                }
                if(curt > 2) cnt++;
            }
        }

        return cnt;
    }

    private static boolean inRange(int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
}