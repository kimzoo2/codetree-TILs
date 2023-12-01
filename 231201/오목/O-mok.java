import java.io.*;
public class Main {
    static int LEN = 19;
    static int[][] board = new int[LEN+1][LEN+1];
    static int color = 0;
    static int ansX = 0;
    static int ansY = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < LEN; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j < LEN; j++) {
                board[i][j] = Integer.parseInt(split[j - 1]);
            }
        }
        for (int i = 1; i < LEN; i++) {
            for (int j = 1; j < LEN; j++) {
                if (board[i][j] != 0 && isCorrect(i, j)) {
                    break;
                }
            }
            if (color > 0) break;
        }
        System.out.println(color);
        if (color > 0) {
            System.out.println(ansX + " " + ansY);
        }
        ;
    }

    private static boolean isCorrect(int x, int y) {
        // 가로 확인
        if (containsRow(x, y) || containsColumn(x, y) ||
                containsUpwardRight(x, y) || containsDownwardRight(x, y)) {
            color = board[x][y];
            return true;
        }
        return false;
    }

    private static boolean containsRow(int x, int y) {
        int color = board[x][y];
        for (int i = y; i < y + 5; i++) {
            // 범위를 넘기거나 다른 색이면 false
            if (!inRange(x, i) || board[x][i] != color) {
                return false;
            }
        }
        ansX = x;
        ansY = y + 2;
        return true;
    }

    private static boolean containsColumn(int x, int y) {
        int color = board[x][y];
        for (int i = x; i < x + 5; i++) {
            // 범위를 넘기거나 다른 색이면 false
            if (!inRange(i, y) || board[i][y] != color) {
                return false;
            }
        }
        ansX = x + 2;
        ansY = y;
        return true;
    }

    private static boolean containsUpwardRight(int x, int y) {
        int color = board[x][y];
        for (int i = x; i > x - 5; i--) {
            if (!inRange(i, y) || board[i][y++] != color) {
                return false;
            }
        }
        ansX = x - 2;
        ansY = y - 3;
        return true;
    }

    private static boolean containsDownwardRight(int x, int y) {
        int color = board[x][y];
        for (int i = x; i < x + 5; i++) {
            if (!inRange(i, y) || board[i][y++] != color) {
                return false;
            }
        }
        ansX = x + 2;
        ansY = y - 3;
        return true;
    }

    private static boolean inRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < LEN && y < LEN);
    }
}