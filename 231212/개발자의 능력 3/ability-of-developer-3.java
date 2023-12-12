import java.io.*;
public class Main {
    static int CNT = 6;
    static int[] developers = new int[CNT];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < CNT; i++) {
            developers[i] = Integer.parseInt(input[i]);
        }
        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < CNT; i++) {
            for (int j = i+1; j < CNT; j++) {
                for (int k = j+1; k < CNT; k++) {
                    minScore = Math.min(minScore, getDiff(i, j, k));
                }
            }
        }
        System.out.println(minScore);
    }

    private static int getDiff(int i, int j, int k) {
        int team1 = developers[i] + developers[j] + developers[k];
        int sum = 0;
        for (int developer : developers) {
            sum += developer;
        }
        int team2 = sum - team1;
        return Math.abs(team2 - team1);
    }
}