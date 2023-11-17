import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int[] students = new int[n+1];
        int idx = -1;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            students[num]++;
            if(students[num] >= k){
                idx = num;
            }
        }
        System.out.println(idx);
    }
}