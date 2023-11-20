import java.io.*;
public class Main {
    static int MAX_LEN = 1_000_000;
    static int[] aDistance = new int[MAX_LEN + 1];
    static int[] bDistance = new int[MAX_LEN + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int curIdx = 1;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            while(t-- > 0) {
                aDistance[curIdx] = aDistance[curIdx] + v;
                curIdx++;
            }
        }
        curIdx = 1;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            while(t-- > 0) {
                bDistance[curIdx] = bDistance[curIdx] + v;
                curIdx++;
            }
        }
        int lastRanking = 0;
        int cnt = 0;
        for (int i = 1; i < curIdx; i++) {
            if(aDistance[i] == bDistance[i]) {
                if(lastRanking != 3) {
                    cnt++;
                    lastRanking = 3;
                }
            }
            else if(aDistance[i] > bDistance[i]) {
                if(lastRanking != 1) {
                    cnt++;
                    lastRanking = 1;
                }
            }
            else {
                if(lastRanking != 2) {
                    cnt++;
                    lastRanking = 2;
                }
            }
        }
        System.out.println(cnt);
    }
}