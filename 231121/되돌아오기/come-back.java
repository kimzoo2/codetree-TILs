import java.io.*;

public class Main {
    static int SECOND = 0;
    static int X = 0;
    static int Y = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int dirNum = 0;
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

            if(X == 0 && Y == 0){
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