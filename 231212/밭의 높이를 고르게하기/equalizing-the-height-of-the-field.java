import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 밭의 높낮이가 너무 엉망진창이라 일정 구간만이라도 고르게 하려고합니다.
        // 낮은 밭의 높이를 1 올릴때와, 높은 밭의 높이를 1 낮출때 소모되는 비용은 1로 같습니다. N개의 밭의 높이가 주어지면 연속하게 최소 T번 이상 H높이로 나오게끔 하려고 할 때, 필요한 최소 비용을 구하는 프로그램을 작성해보세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputList = br.readLine().split(" ");
        int n = Integer.parseInt(inputList[0]); // 밭의 개수
        int h = Integer.parseInt(inputList[1]); // 높이 제한
        int t = Integer.parseInt(inputList[2]); // 높이 맞는 땅의 범위
        String[] fieldInputList = br.readLine().split(" ");
        int[] fields = new int[n];

        for (int i = 0; i < n; i++) {
            fields[i] = Integer.parseInt(fieldInputList[i]);
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i <= n-t; i++) {
            int cost = 0;
            for (int j = i; j < i+t; j++) {
                cost += Math.abs(fields[j] - h);
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);

    }
}