import java.io.*;

public class Main {
    static int MAX_LENGTH = 1_000_000;
    static int[] aRobot = new int[MAX_LENGTH + 1];
    static int[] bRobot = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int aTotalTime = 1;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char direction = input[1].charAt(0);
            while(time-- > 0){
                if(direction == 'R')
                    aRobot[aTotalTime] = aRobot[aTotalTime-1] + 1;
                else
                    aRobot[aTotalTime] = aRobot[aTotalTime-1] - 1;
                aTotalTime++;
            }
        }

        int bTotalTime = 1;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char direction = input[1].charAt(0);
            while(time-- > 0){
                if(direction == 'R')
                    bRobot[bTotalTime] = bRobot[bTotalTime-1] + 1;
                else
                    bRobot[bTotalTime] = bRobot[bTotalTime-1] - 1;
                bTotalTime++;
            }
        }

        int cnt = 0;
        int[][] lastIdx = new int[1][2];
        int totalIdx = Math.max(aTotalTime, bTotalTime);
        for (int i = 0; i < totalIdx; i++) {
            int a = i < aTotalTime ? aRobot[i] : aRobot[aTotalTime-1];
            int b = i < bTotalTime ? bRobot[i] : bRobot[bTotalTime-1];
            if(a == b){
                // 직전 위치가 다른 위치에 있을 때만 카운트한다.
                if(lastIdx[0][0] != lastIdx[0][1]) {
                    cnt++;
                }
            }
            lastIdx[0][0] = a;
            lastIdx[0][1] = b;
        }

        System.out.println(cnt);
    }
}