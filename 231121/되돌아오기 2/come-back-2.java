import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int dirNum = 3;
        int len = input.length();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int ans = 0;
        boolean isComeback = false;

        for (int i = 0; i < len; i++) {
            ans++;
            char direction = input.charAt(i);
            if(direction == 'R') // 오른쪽 90도
                dirNum = (dirNum + 1) % 4;
            else if(direction == 'L')
                dirNum = (dirNum - 1) % 4;
            else {
                x += dx[dirNum];
                y += dy[dirNum];

                if(x == 0 && y == 0) {
                    isComeback = true;
                    break;
                }
            }
        }
        System.out.println(isComeback ? ans : -1);
    }
}