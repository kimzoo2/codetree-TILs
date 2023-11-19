import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n명의 개발자
        // T번에 걸쳐 t초에 x와 y와 악수했다
        // k번의 악수 동안만 전염이 된다
        // 전염병 걸린 개발자의 번호 P가 주어진다
        // 누가 전염병에 걸렸는가?
        // 전염된 사람끼리 악수를 해도 전염병을 옮기게 된 횟수에 포함한다
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // n명의 개발자
        int k = Integer.parseInt(split[1]); // k번의 악수동안만 전염병 옮김
        int p = Integer.parseInt(split[2]); // 전염병 걸린 개발자
        int t = Integer.parseInt(split[3]); // 악수 정보 횟수
        int[] infectionCntList = new int[n+1];
        int[] programmers = new int[n+1];
        infectionCntList[p] = k;
        programmers[p]++;

        //4 2 2 3
        //7 1 2
        //5 2 3
        //6 2 4

        int[][] handShakeList = new int[t][3];

        for (int i = 0; i < t; i++) {
            String[] handShake = br.readLine().split(" ");
            handShakeList[i][0] = Integer.parseInt(handShake[0]);
            handShakeList[i][1] = Integer.parseInt(handShake[1]);
            handShakeList[i][2] = Integer.parseInt(handShake[2]);
        }

        Arrays.sort(handShakeList, (o1, o2) -> {return o1[0] - o2[0];});

        // 감염된 시간을 담고 있는 배열
        for (int i = 0; i < t; i++) {
            int x = handShakeList[i][1];
            int y = handShakeList[i][2];

            if(infectionCntList[x] > 0 && infectionCntList[y] > 0){
                infectionCntList[x]--;
                infectionCntList[y]--;
            }else if(infectionCntList[x] > 0){
                infectionCntList[x]--;
                if(programmers[y] == 0) {
                    infectionCntList[y] = k;
                }
                programmers[y] = 1;

            }else if(infectionCntList[y] > 0){
                infectionCntList[y]--;
                if(programmers[x] == 0) {
                    infectionCntList[x] = k;
                }
                programmers[x] = 1;
            }
        }

        // 감염여부 확인
        for (int i = 1; i < n+1; i++) {
            System.out.print(programmers[i]);
        }
    }
}