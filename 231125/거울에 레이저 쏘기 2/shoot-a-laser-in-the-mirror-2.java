import java.io.*;
public class Main {
    static int n = 0;
    static int dirNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = input.charAt(j);
            }
        }
        int enterNum = Integer.parseInt(br.readLine());
        // input의 x,y 좌표를 구한다.
        int[] xy = getXY(enterNum-1, n);
        int x = xy[0];
        int y = xy[1];
        int cnt = 0;

        while (true) {
            char mirror = grid[x][y];

            if(mirror == '/') {
                if(dirNum == 0 || dirNum == 2) dirNum =(dirNum + 3) % 4;
                else dirNum = (dirNum + 1) % 4;
            }else{
                if(dirNum == 0 || dirNum == 2) dirNum =(dirNum + 1) % 4;
                else dirNum = (dirNum + 3) % 4;
            }

            x += dx[dirNum];
            y += dy[dirNum];

            cnt++;

            if(!inRange(x, y)){
                System.out.println(cnt);
                break;
            }
            dirNum = (dirNum + 2) % 4; // 다음칸은 반대방향에서 접근한다.

        }

    }

    private static int[] getXY(int num, int range){
        dirNum = num / range; //0:북 1:동 2:남 3:서
        int modNum = num % range;
        range -=1;
        int[] x = {0, modNum, range, range-modNum};
        int[] y = {modNum, range, range-modNum, 0};
        int[] xy = {x[dirNum], y[dirNum]};

        return xy;
    }

    private static boolean inRange(int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < n);
    }
}