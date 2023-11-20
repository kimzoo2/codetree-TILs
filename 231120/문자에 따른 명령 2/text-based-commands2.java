import java.io.*;
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int x = 0;
        int y = 0;
        int dirNum = 3;

        //L이면 왼쪽 90도
        //R이면 오른쪽 90도
        for (int i = 0; i < len; i++) {
            char direction = input.charAt(i);
            if(direction == 'L') dirNum = (dirNum - 1 + 4) % 4;
            else if (direction== 'R') dirNum = (dirNum + 1) % 4;
            else {
                x += dx[dirNum];
                y += dy[dirNum];
            }
        }
        System.out.println(x + " " + y);
    }
}