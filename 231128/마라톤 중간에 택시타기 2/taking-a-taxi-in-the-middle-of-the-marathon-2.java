import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] checkPoints = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            checkPoints[i][0] = Integer.parseInt(split[0]);
            checkPoints[i][1] = Integer.parseInt(split[1]);
        }

        int min = Integer.MAX_VALUE;
        int idx = 1;
        int x1, y1, x2, y2;
        x1 = x2 = y1 = y2 = 0;

        for (int i = 0; i<n-2; i++) { // 0 1
            int sum = 0;
            x1 = 0;
            y1 = 0;
            for (int j = 1; j < n-1; j++) {// 1, 2
                if(idx == j) continue;

                x2 = checkPoints[j][0];
                y2 = checkPoints[j][1];

                sum += Math.abs(x1 - x2) + Math.abs(y1 - y2);
                x1 = x2;
                y1 = y2;
            }
            idx++;
            sum += Math.abs(x1 - checkPoints[n-1][0]) + Math.abs(y1 - checkPoints[n-1][1]);
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}