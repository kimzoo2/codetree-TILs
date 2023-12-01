import java.io.*;
public class Main {
    static int MAXLEN = 510;
    static int OFFSET = 10;
    static int[][] grid = new int[MAXLEN+2][MAXLEN+2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] locations = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] query = br.readLine().split(" ");
            locations[i][0] = Integer.parseInt(query[0]);
            locations[i][1] = Integer.parseInt(query[1]);
        }

        for (int i = 0; i < n; i++) {
            int x1 = locations[i][0]+1;
            int y1 = locations[i][1]+1;
            int x2 = x1 + OFFSET;
            int y2 = y1 + OFFSET;
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    grid[j][k] = 1;
                }
            }
        }
        int area = 0;
        for (int i = 0; i <= MAXLEN; i++) {
            for (int j = 0; j <= MAXLEN; j++) {
                int bx = i-1;
                int by = j-1;
                if(inRange(i, by) && grid[i][by] != grid[i][j]) area++;
                if(inRange(bx, j) && grid[bx][j] != grid[i][j]) area++;
            }
        }

        System.out.println(area);

    }

    private static boolean inRange(int x, int y){
        return (x >= 0 && y >= 0 && x <=MAXLEN && y <= MAXLEN);
    }
}