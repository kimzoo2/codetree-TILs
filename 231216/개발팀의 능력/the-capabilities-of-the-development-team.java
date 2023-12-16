import java.io.*;
public class Main {
    static int LEN = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] developerAbilityList = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            developerAbilityList[i] = Integer.parseInt(split[i]);
        }

        int sum = 0;

        for (int i = 0; i < LEN; i++) {
            sum += developerAbilityList[i];
        }

        int minAbility = Integer.MAX_VALUE;
        for (int i = 0; i < LEN; i++) {
            for (int j = i+1; j < LEN; j++) {
                for (int k = 0; k < LEN; k++) {
                    for (int l = k+1; l < LEN; l++) {
                        if(k == i || k == j || l == i || l == j) continue;

                        // 팀간의 능력
                        int team1 = developerAbilityList[i] + developerAbilityList[j];
                        int team2 = developerAbilityList[k] + developerAbilityList[l];
                        int team3 = sum - team1 - team2;
                        if(team3 != team2 && team2 != team1 && team1 != team3) {
                            // 가장 점수가 높은 팀
                            int ret = Math.abs(team1 - team2);
                            ret = Math.max(ret, Math.abs(team2 - team3));
                            ret = Math.max(ret, Math.abs(team3 - team1));
                            minAbility = Math.min(minAbility, ret);
                        }
                    }
                }
            }
        }
        System.out.println(minAbility == Integer.MAX_VALUE ? -1 : minAbility);

    }
}