import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(isDecimal(i)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isDecimal(int n){

        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}