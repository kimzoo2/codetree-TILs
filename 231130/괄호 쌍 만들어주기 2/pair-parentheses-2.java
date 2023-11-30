import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int cnt = 0;

        for (int j = 0; j < len-2; j++) {
            for (int k = j+1; k < len-1; k++) {
                if(str.charAt(j) == str.charAt(j+1) && str.charAt(j) == '(' &&
                   str.charAt(k) == str.charAt(k+1) && str.charAt(k) == ')') cnt++;
            }
        }

        System.out.println(cnt);
    }
}