import java.io.*;
public class Main {
    static int MAX_N2 = 1_000_000;
    static int[] aArr = new int[MAX_N2+1];
    static int[] bArr = new int[MAX_N2+1];
    static int[] totalArr = new int[MAX_N2+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // A의 이동
        int m = Integer.parseInt(split[1]); // B의 이동

        int curIdx = 0;
        int totalDistance = 0;

        // 속도 v , 시간 t
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);

            for (int j = 1; j <= t; j++) {
                aArr[curIdx++] = (j * v) + totalDistance;
            }
            totalDistance = aArr[curIdx-1];
        }

        curIdx = 0;
        totalDistance = 0;

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            for (int j = 1; j <= t; j++) {
                bArr[curIdx++] = (j * v) + totalDistance;
            }
            totalDistance = bArr[curIdx-1];
        }

        for (int i = 0; i < curIdx; i++) {
            if(bArr[i] > aArr[i]) totalArr[i] = 1;
            else if(bArr[i] < aArr[i]) totalArr[i] = 2;
        }

        int cnt = 0;
        int lastIdx = 0;
        for (int i = 0; i < curIdx; i++) {
            if(totalArr[i] > 0 && lastIdx != totalArr[i]){
                lastIdx =totalArr[i];
                cnt++;
            }
        }

        System.out.println(cnt == 0 ? cnt : cnt-1);

    }
}