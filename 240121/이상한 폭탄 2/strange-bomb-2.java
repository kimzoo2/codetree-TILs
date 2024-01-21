import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] bombs = new int[n];

        for (int i = 0; i < n; i++) {
            bombs[i] = Integer.parseInt(br.readLine());
        }

        int max = -1;

        for (int i = 0; i <n; i++) {
            for (int j = i+1; j <= i+k; j++) {
                if(j == n) break;
                if(bombs[i] == bombs[j]){
                    max = Math.max(max, bombs[i]);
                }
            }
        }
        System.out.println(max);
    }
}