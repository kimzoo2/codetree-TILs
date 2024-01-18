import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int cnt = Integer.parseInt(split[0]);
        int budget = Integer.parseInt(split[1]);
        int[] students = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;

        for (int i = 0; i < cnt; i++) {
            int ans = 0;
            int sum = 0;
            for (int j = 0; j < cnt; j++) {
                int price = students[j];
                if(i == j) price /= 2;
                sum += price;
                if(sum > budget) break;
                ans++;
            }
            max = Math.max(ans, max);
        }

        System.out.println(max);
    }
}