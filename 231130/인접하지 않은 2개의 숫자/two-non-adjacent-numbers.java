import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+2; j < n; j++) {
                max = Math.max(max, Integer.parseInt(split[i]) + Integer.parseInt(split[j]));
            }
        }
        System.out.println(max);
    }
}