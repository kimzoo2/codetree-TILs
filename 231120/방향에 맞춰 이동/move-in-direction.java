import java.io.*;
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int dirNum = 0;
            char direction = split[0].charAt(0);
            int distance = Integer.parseInt(split[1]);
            switch (direction){
                case('E') : dirNum = 0; break;
                case('N') : dirNum = 1; break;
                case('W') : dirNum = 2; break;
                default : dirNum = 3; break;
            }
            x += (dx[dirNum] * distance);
            y += (dy[dirNum] * distance);
        }
        System.out.println(x + " " + y);
    }
}