import java.io.*;
public class Main {
    static int LENGTH = 6;
    public static void main(String[] args) throws IOException {
        // 개발자 6명의 알고리즘 능력을 수치화해 정수로 주어지면
        //6명을 2명씩 3팀으로 배정해줍니다. 능력 총합이 가장 큰 팀과 가장 작은 팀의 차이를 최소화 해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] developerAbilityList = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            developerAbilityList[i] = Integer.parseInt(split[i]);
        }
        int sum = 0;

        for (int i = 0; i < LENGTH; i++) {
            sum += developerAbilityList[i];
        }

        int minAbility = Integer.MAX_VALUE;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                for (int k = 0; k < LENGTH; k++) {
                    for (int l = 0; l < LENGTH; l++) {
                        if (i == j || j == k || j == i || k == i || l == i || l == j || l == k) continue;

                        // 팀간의 능력
                        int team1 = developerAbilityList[i] + developerAbilityList[j];
                        int team2 = developerAbilityList[k] + developerAbilityList[l];
                        int team3 = sum - team1 - team2;

                        int max = team1;
                        int min = team1;

                        // 가장 점수가 높은 팀
                        if (max < team2) {
                            max = team2;
                            if (max < team3) max = team3;
                        }else if (max < team3) {
                            max = team3;
                        }
                        // 가장 점수가 낮은 팀
                        if (min > team2) {
                            min = team2;
                            if (min > team3) min = team3;
                        }else if(min > team3){
                            min = team3;
                        }
                        minAbility = Math.min(minAbility, max - min);
                    }
                }
            }
        }
        System.out.println(minAbility);
    }
}