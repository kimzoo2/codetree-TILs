import java.io.*;

public class Main {
    static int OFFSET = 1_000;
    static int MAX_LEN = OFFSET * 2 + 1;
    static int SECOND = 0;
    static int X = OFFSET;
    static int Y = OFFSET;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int dirNum = 0;
        int[][] grid = new int[MAX_LEN][MAX_LEN];
        int x = OFFSET;
        int y = OFFSET;
        boolean isReturn = false;

        for (int i = 0; i < cnt; i++) {
            String[] strings = br.readLine().split(" ");
            char direction = strings[0].charAt(0);
            int distance = Integer.parseInt(strings[1]);
            dirNum = getDirNum(direction);

            if(getSecond(distance,dirNum)) {
                isReturn = true;
                break;
            }
        }

        System.out.println(isReturn ? SECOND : -1);
    }

    private static boolean getSecond(int distance, int dirNum) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int j = 0; j < distance; j++) {
            SECOND++;
            X += dx[dirNum];
            Y += dy[dirNum];

            if(X == OFFSET && Y == OFFSET){
                return true;
            }
        }
        return false;
    }

    private static int getDirNum(char ch){
        char[] chArr = {'E', 'S', 'W', 'N'};
        for (int i = 0; i < 4; i++) {
            if(ch== chArr[i]) return i;
        }
        return 0;
    }
}