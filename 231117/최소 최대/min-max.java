import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int min = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[0]);
        for (int i = 1; i < cnt; i++) {
            int compareNum = Integer.parseInt(split[i]);
            min = Math.min(min, compareNum);
            max = Math.max(max, compareNum);
        }

        System.out.println(min + " " + max);
    }
}