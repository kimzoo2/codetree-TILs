import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int cnt = Integer.parseInt(split[0]);
        int devCnt = Integer.parseInt(split[1]);
        int[][] score = new int[cnt][devCnt];

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < devCnt; j++) {
                score[i][j] = Integer.parseInt(input[j]);
            }
        }
        int ans = 0;

        //항상 a번 개발자가 b번 개발자보다 더 높은 순위였던 서로 다른 (a, b) 쌍의 수를 구하는 프로그램을 작성해보세요.
        for (int i = 1; i <= devCnt; i++) {
            for (int j = 1; j <= devCnt; j++) {
                if(i==j) continue;
                boolean isHigher = true;
                int targetIdx = -1;
                int compareIdx = -1;
                for (int k = 0; k < cnt; k++) {
                    for (int l = 0; l < devCnt; l++) {
                        if(score[k][l] == i) targetIdx = l;
                        if(score[k][l] == j) compareIdx = l;
                    }
                    if(targetIdx > compareIdx) {
                        isHigher = false;
                        break;
                    }
                }
                if(isHigher) ans++;
            }
        }

        System.out.println(ans);
    }
}