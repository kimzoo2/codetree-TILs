import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] room = new int[n];

        for (int i = 0; i < n; i++) {
            room[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int distance = 0;
                if (i == j) continue;
                distance = (j + n - i) % n;
                sum += room[j] * distance;
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}