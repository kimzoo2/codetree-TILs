import java.io.*;
public class Main {
    static int MAX_LEN = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        int[] times = new int[MAX_LEN + 1];
        int max = Integer.MIN_VALUE;
        int timeCnt = 0;

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if(i == j) continue;
                for (int k = arr[j][0]; k < arr[j][1]; k++) {
                    times[k]++;
                }
            }
            timeCnt = 0;
            for (int j = 0; j <= MAX_LEN; j++) {
                if(times[j] > 0) timeCnt++;
            }
            max = Math.max(max, timeCnt);

            for (int j = 0; j < MAX_LEN+1; j++) {
                times[j] = 0;
            }
        }
        System.out.println(max);
    }
}