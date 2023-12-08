import java.io.*;
public class Main {
    static int MAX_LEN = 500;
    static int OFFSET = 200;
    public static void main(String[] args) throws IOException {
        //1차원 직선 위에 총 N개의 바구니가 놓여 있고, 바구니 안에는 사탕이 담겨 있습니다.
        // 중심점 c를 잘 잡아 [c-K, c+K] 구간에 있는 사탕의 수가 최대가 되도록 하는 프로그램을 작성해보세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]); // 바구니 수
        int k = Integer.parseInt(split[1]); // 구간 크기
        int[] baskets = new int[MAX_LEN+1];

        for (int i = 0; i < n; i++) {
            String[] basketInfo = br.readLine().split(" ");
            int candyCnt = Integer.parseInt(basketInfo[0]);
            int idx = Integer.parseInt(basketInfo[1]) + OFFSET;
            baskets[idx] += candyCnt;
        }

        int max = 0;
        for (int i = k; i <= MAX_LEN-k; i++) {
            int sum = 0;
            for (int j = i-k; j <= i+k; j++) {
                sum += baskets[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}