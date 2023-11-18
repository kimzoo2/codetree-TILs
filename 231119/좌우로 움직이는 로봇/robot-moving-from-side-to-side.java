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

        int aTotalTime = 0;
        int aTotalDistance = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char direction = input[1].charAt(0);
            if(direction == 'R'){
                int x1 = aTotalDistance;
                int x2 = aTotalDistance + time;
                for (int j = x1; j < x2; j++) {
                    aRobot[aTotalTime++] = j;
                }
                aTotalDistance += time;
            }else{
                int x1 = aTotalDistance;
                int x2 = aTotalDistance - time;
                for (int j = x1; j > x2; j--) {
                    aRobot[aTotalTime++] = j;
                }
                aTotalDistance -= time;
            }
        }

        int bTotalTime = 0;
        int bTotalDistance = 0;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char direction = input[1].charAt(0);
            if(direction == 'R'){
                int x1 = bTotalDistance;
                int x2 = bTotalDistance + time;
                for (int j = x1; j < x2; j++) {
                    bRobot[bTotalTime++] = j;
                }
                bTotalDistance += time;
            }else{
                int x1 = bTotalDistance;
                int x2 = bTotalDistance - time;
                for (int j = x1; j > x2; j--) {
                    bRobot[bTotalTime++] = j;
                }
                bTotalDistance -= time;
            }
        }

        int cnt = 0;
        int[][] lastIdx = new int[1][2];
        for (int i = 1; i <= bTotalTime; i++) {
            if(aRobot[i] == bRobot[i]){
                // 직전 위치에 다른 위치에 있을 때만 카운트한다.
                if(lastIdx[0][0] != lastIdx[0][1]) {
                    cnt++;
                }
            }
            lastIdx[0][0] = aRobot[i];
            lastIdx[0][1] = bRobot[i];
        }

        System.out.println(cnt);
    }
}