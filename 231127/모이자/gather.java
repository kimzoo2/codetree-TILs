import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                sum = sum + (Math.abs(j-i) * Integer.parseInt(split[j]));
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}