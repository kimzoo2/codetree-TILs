import java.io.*;
public class Main {
    static int INPUT_N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 격자 크기
        int t = Integer.parseInt(s[1]); // 시간
        INPUT_N = n;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]) -1;
        int y = Integer.parseInt(input[1]) -1;
        int dirNum = getDirectionNumber(input[2].charAt(0));
        for (int i = 0; i < t; i++) {
            x += dx[dirNum];
            y += dy[dirNum];
            if(!inRange(x, y)){
                x -= dx[dirNum];
                y -= dy[dirNum];
                dirNum = (dirNum + 2) % 4;
            }
        }

        System.out.println(x+1 + " " + (y+1));
    }
    private static int getDirectionNumber(char charAt) {
        switch (charAt){
            case('U') : return 3;
            case('R') : return 0;
            case('D') : return 1;
            default : return 2;
        }
    }
    private static boolean inRange(int x, int y){
        return (x >= 0 && y >= 0 && x < INPUT_N && y < INPUT_N);
    }
}