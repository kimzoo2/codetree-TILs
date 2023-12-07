import java.io.*;
public class Main {
    static int LINE_MAX_LENGTH = 10_000;
    static int[] arr = new int[LINE_MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // N명의 위치
        int k = Integer.parseInt(split[1]); // 사진 크기

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]); // 위치
            char alphabet = s[1].charAt(0);
            arr[x] = alphabet == 'G' ? 1 : 2;
        }
        int max = 0;
        // K구간의 최대 점수를 구한다.
        for (int i = 0; i < LINE_MAX_LENGTH-k; i++) {
            int sum = 0;
            for (int j = i; j <= i+k; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}