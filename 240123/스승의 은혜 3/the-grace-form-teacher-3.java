import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int cnt = Integer.parseInt(split[0]);
        int budget = Integer.parseInt(split[1]);
        int[][] presents = new int[cnt][2];

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");
            presents[i][0] = Integer.parseInt(input[0]);
            presents[i][1] = Integer.parseInt(input[1]);
        }


        int ans = 0;
        for (int i = 0; i < cnt; i++) {
            int[][] tempPresent = new int[cnt][2];
            for (int j = 0; j < cnt; j++) {
                tempPresent[j][0] = presents[j][0];
                tempPresent[j][1] = presents[j][1];
                if(i == j) {
                    tempPresent[j][0] = presents[j][0] / 2;
                }
            }

            Arrays.sort(tempPresent, (o1, o2) -> {
                return o1[0] + o1[1] -o2[0] + o2[1]; //합기준 오름차순
            });

            int n = 0;
            int sum = 0;
            for (int j = 0; j < cnt; j++) {
                sum += tempPresent[j][0] + tempPresent[j][1];
                if(budget < sum) break;
                n++;
            }
            ans = Math.max(ans, n);
        }

        System.out.println(ans);

        // 5 24
        // 4 2
        // 2 0
        // 8 1
        // 6 3
        // 12 5
    }
}